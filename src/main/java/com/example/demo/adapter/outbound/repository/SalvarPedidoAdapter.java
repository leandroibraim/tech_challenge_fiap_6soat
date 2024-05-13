package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.outbound.pedido.SalvarPedidoAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SalvarPedidoAdapter implements SalvarPedidoAdapterPort {

    private PedidoRepository repository;

    @Autowired
    public SalvarPedidoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean execute(Pedido pedido) {
        final var result = repository.listarPedidosPorStatus("", LocalDateTime.now());
        //return PedidoMapper.INSTANCE.mapFrom(result);
        return Boolean.TRUE;
    }
}
