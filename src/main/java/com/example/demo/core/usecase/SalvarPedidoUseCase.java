package com.example.demo.core.usecase;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.inbound.pedido.SalvarPedidoUseCasePort;
import com.example.demo.core.ports.outbound.pedido.SalvarPedidoAdapterPort;

import java.time.LocalDateTime;

public class SalvarPedidoUseCase implements SalvarPedidoUseCasePort {

    private final SalvarPedidoAdapterPort salvarPedidoAdapterPort;

    public SalvarPedidoUseCase(SalvarPedidoAdapterPort salvarPedidoAdapterPort) {
        this.salvarPedidoAdapterPort = salvarPedidoAdapterPort;
    }

    @Override
    public void execute(Pedido pedido) {
        //TODO melhorar logica de geracao de numero pedido
        pedido.setNumeroPedido("ORDER#".concat(String.valueOf(LocalDateTime.now().getSecond())));

        //TODO ajustar status pra um enum
        pedido.setStatus("RECEBIDO");

        salvarPedidoAdapterPort.execute(pedido);
    }

}
