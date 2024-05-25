package com.example.demo.core.usecase;

import com.example.demo.adapter.outbound.AlterarStatusPedidoEmPreparacaoAdapter;
import com.example.demo.core.domain.Pagamento;
import com.example.demo.core.ports.inbound.pagamento.PagarPedidoUseCasePort;
import com.example.demo.core.ports.inbound.pedido.AlterarStatusPedidoEmPreparacaoUseCasePort;
import com.example.demo.core.ports.outbound.pagamento.PagarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.pagamento.SalvarPagamentoAdapterPort;

public class PagarPedidoUseCase implements PagarPedidoUseCasePort {

    private final PagarPedidoAdapterPort pagarPedidoAdapterPort;
    private final SalvarPagamentoAdapterPort salvarPagamentoAdapterPort;
    private final AlterarStatusPedidoEmPreparacaoUseCasePort alterarStatusPedidoEmPreparacaoUseCasePort;

    public PagarPedidoUseCase(PagarPedidoAdapterPort pagarPedidoAdapterPort, SalvarPagamentoAdapterPort salvarPagamentoAdapterPort, AlterarStatusPedidoEmPreparacaoUseCasePort alterarStatusPedidoEmPreparacaoUseCasePort) {
        this.pagarPedidoAdapterPort = pagarPedidoAdapterPort;
        this.salvarPagamentoAdapterPort = salvarPagamentoAdapterPort;
        this.alterarStatusPedidoEmPreparacaoUseCasePort = alterarStatusPedidoEmPreparacaoUseCasePort;
    }

    @Override
    public void checkout(Pagamento pagamento) {
        Pagamento pago = pagarPedidoAdapterPort.pagar(pagamento);
        salvarPagamentoAdapterPort.salvar(pago);
        alterarStatusPedidoEmPreparacaoUseCasePort.execute(pagamento.getNumeroPedido());
    }
}
