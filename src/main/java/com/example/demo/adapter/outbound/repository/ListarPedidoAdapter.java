package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.outbound.pedido.ListarPedidosAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ListarPedidoAdapter implements ListarPedidosAdapterPort {

    private PedidoRepository repository;

    @Autowired
    public ListarPedidoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        final var result = repository.listarPedidosPorStatus("", LocalDateTime.now());
        //return PedidoMapper.INSTANCE.mapFrom(result);
        return List.of();
    }
}
