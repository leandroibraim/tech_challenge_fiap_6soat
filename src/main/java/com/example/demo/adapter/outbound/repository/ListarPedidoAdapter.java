package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.outbound.pedido.ListarPedidoPort;

import java.util.List;

public class ListarPedidoAdapter implements ListarPedidoPort {


    @Override
    public List<Pedido> execute() {



        return List.of();
    }
}
