package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Pedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarPedidoAdapter{

    private final PedidoRepository repository;

    public ListarPedidoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> execute() {
        final var result = repository.listarProduto();
        return PedidoMapper.INSTANCE.mapFrom(result);
    }
}
