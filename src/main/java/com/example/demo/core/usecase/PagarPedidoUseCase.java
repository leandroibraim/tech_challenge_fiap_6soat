package com.example.demo.core.usecase;

import com.example.demo.core.domain.Pagamento;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.inbound.pagamento.PagarPedidoUseCasePort;
import com.example.demo.core.ports.outbound.pagamento.PagarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.pagamento.SalvarPagamentoAdapterPort;
import com.example.demo.core.ports.outbound.pedido.AtualizarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.pedido.BuscarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.pedido.PedidoEmPreparacaoAdapterPort;
import com.example.demo.core.ports.outbound.pedido.SalvarPedidoAdapterPort;

import java.math.BigDecimal;
import java.util.Objects;

public class PagarPedidoUseCase implements PagarPedidoUseCasePort {

    private final PagarPedidoAdapterPort pagarPedidoAdapterPort;
    private final SalvarPagamentoAdapterPort salvarPagamentoAdapterPort;
    private final PedidoEmPreparacaoAdapterPort pedidoEmPreparacaoAdapter;
    private final BuscarPedidoAdapterPort buscarPedidoAdapterPort;
    private final SalvarPedidoAdapterPort salvarPedidoAdapterPort;
    private final AtualizarPedidoAdapterPort atualizarPedidoAdapterPort;

    public PagarPedidoUseCase(PagarPedidoAdapterPort pagarPedidoAdapterPort, SalvarPagamentoAdapterPort salvarPagamentoAdapterPort, PedidoEmPreparacaoAdapterPort pedidoEmPreparacaoAdapter, BuscarPedidoAdapterPort buscarPedidoAdapterPort, SalvarPedidoAdapterPort salvarPedidoAdapterPort, AtualizarPedidoAdapterPort atualizarPedidoAdapterPort) {
        this.pagarPedidoAdapterPort = pagarPedidoAdapterPort;
        this.salvarPagamentoAdapterPort = salvarPagamentoAdapterPort;
        this.pedidoEmPreparacaoAdapter = pedidoEmPreparacaoAdapter;
        this.buscarPedidoAdapterPort = buscarPedidoAdapterPort;
        this.salvarPedidoAdapterPort = salvarPedidoAdapterPort;
        this.atualizarPedidoAdapterPort = atualizarPedidoAdapterPort;
    }

    @Override
    public void checkout(Pagamento pagamento) {

        final Pagamento pago = pagarPedidoAdapterPort.pagar(pagamento);
        Pedido pedido = buscarPedidoAdapterPort.execute(pagamento.getNumeroPedido());

        if(Objects.isNull(pedido)){
            throw new RuntimeException();
        }

        pedido.setEtapa("EM_PREPARACAO");
        pago.setNumeroPedido(pedido.getNumeroPedido());
        pago.setValorTotal(BigDecimal.valueOf(pedido.getValorTotal()));

        pago.setPedido(pedido);
        final var dadosPagamento = salvarPagamentoAdapterPort.salvar(pago);

        pedido.setIdPagamento(dadosPagamento.getIdPagamento());

        //Consulta id do pagamento
        //Pedido pedidos = pedidoEmPreparacaoAdapter.execute(pagamento.getNumeroPedido());

        atualizarPedidoAdapterPort.execute(pedido);


    }
}
