package com.example.demo.core.ports.outbound.pedido;

import com.example.demo.core.domain.Pedido;
import java.util.List;

public interface ListarPedidoPort {
   List<Pedido> execute();
}