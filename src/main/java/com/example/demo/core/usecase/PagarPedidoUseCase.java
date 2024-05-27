package com.example.demo.core.usecase;

import com.example.demo.core.domain.Pagamento;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.inbound.pagamento.PagarPedidoUseCasePort;
import com.example.demo.core.ports.inbound.pedido.PedidoEmPreparacaoUseCasePort;
import com.example.demo.core.ports.outbound.pagamento.PagarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.pagamento.SalvarPagamentoAdapterPort;

import java.math.BigDecimal;

public class PagarPedidoUseCase implements PagarPedidoUseCasePort {

    private final PagarPedidoAdapterPort pagarPedidoAdapterPort;
    private final SalvarPagamentoAdapterPort salvarPagamentoAdapterPort;
    private final PedidoEmPreparacaoUseCasePort pedidoEmPreparacaoUseCasePort;

    public PagarPedidoUseCase(PagarPedidoAdapterPort pagarPedidoAdapterPort, SalvarPagamentoAdapterPort salvarPagamentoAdapterPort, PedidoEmPreparacaoUseCasePort pedidoEmPreparacaoUseCasePort) {
        this.pagarPedidoAdapterPort = pagarPedidoAdapterPort;
        this.salvarPagamentoAdapterPort = salvarPagamentoAdapterPort;
        this.pedidoEmPreparacaoUseCasePort = pedidoEmPreparacaoUseCasePort;
    }

    @Override
    public void checkout(Pagamento pagamento) {
        Pagamento pago = pagarPedidoAdapterPort.pagar(pagamento);
        Pedido pedido = pedidoEmPreparacaoUseCasePort.execute(pagamento.getNumeroPedido());
        pago.setNumeroPedido(pedido.getNumeroPedido());
        pago.setValorTotal(BigDecimal.valueOf(pedido.getValorTotal()));
        salvarPagamentoAdapterPort.salvar(pago);
    }
}
