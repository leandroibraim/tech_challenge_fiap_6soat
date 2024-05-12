package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.outbound.pedido.ListarPedidosAdapterPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarPedidoAdapter implements ListarPedidosAdapterPort {

    private final PedidoRepository repository;

    public ListarPedidoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        final var result = repository.listarProduto();
        return PedidoMapper.INSTANCE.mapFrom(result);
    }
}
