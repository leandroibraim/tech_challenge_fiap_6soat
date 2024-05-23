package com.example.demo.core.usecase;

import com.example.demo.core.domain.Pagamento;
import com.example.demo.core.ports.inbound.pagamento.PagarPedidoUseCasePort;
import com.example.demo.core.ports.outbound.pagamento.PagarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.pagamento.SalvarPagamentoAdapterPort;

public class PagarPedidoUseCase implements PagarPedidoUseCasePort {

    private final PagarPedidoAdapterPort pagarPedidoAdapterPort;
    private final SalvarPagamentoAdapterPort salvarPagamentoAdapterPort;

    public PagarPedidoUseCase(PagarPedidoAdapterPort pagarPedidoAdapterPort, SalvarPagamentoAdapterPort salvarPagamentoAdapterPort) {
        this.pagarPedidoAdapterPort = pagarPedidoAdapterPort;
        this.salvarPagamentoAdapterPort = salvarPagamentoAdapterPort;
    }

    @Override
    public void checkout(Pagamento pagamento) {
        Pagamento pago = pagarPedidoAdapterPort.pagar(pagamento);
        salvarPagamentoAdapterPort.salvar(pago);
    }
}
