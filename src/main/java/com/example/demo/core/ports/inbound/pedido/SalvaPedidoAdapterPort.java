package com.example.demo.core.ports.inbound.pedido;

import com.example.demo.core.domain.Pedido;

public interface SalvaPedidoAdapterPort {

    Pedido salvaPedido(Pedido pedido);
}