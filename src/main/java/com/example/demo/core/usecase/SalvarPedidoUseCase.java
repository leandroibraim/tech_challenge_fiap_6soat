package com.example.demo.core.usecase;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.inbound.pedido.SalvarPedidoUseCasePort;
import com.example.demo.core.ports.outbound.pedido.SalvarPedidoAdapterPort;

public class SalvarPedidoUseCase implements SalvarPedidoUseCasePort {

    private final SalvarPedidoAdapterPort salvarPedidoAdapterPort;

    public SalvarPedidoUseCase(SalvarPedidoAdapterPort salvarPedidoAdapterPort) {
        this.salvarPedidoAdapterPort = salvarPedidoAdapterPort;
    }

    @Override
    public boolean execute(Pedido pedido) {
        return salvarPedidoAdapterPort.execute(pedido);
    }
}
