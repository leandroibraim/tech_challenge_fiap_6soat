package com.example.demo.core.usecase;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.outbound.pedido.ListarPedidoPort;

import java.util.List;

public class ListarPedidosUseCase {

    private final ListarPedidoPort listarPedidoPort;

    public ListarPedidosUseCase(ListarPedidoPort listarPedidoPort) {
        this.listarPedidoPort = listarPedidoPort;
    }

    public List<Pedido> execute(){

        listarPedidoPort.execute();

        return null;
    }
}
