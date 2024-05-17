package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.ports.outbound.pedido.ListaProdutoAdapterPort;
import com.example.demo.core.ports.outbound.pedido.SalvarPedidoAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListarProdutoAdapter implements ListaProdutoAdapterPort {

    private PedidoRepository repository;

    @Autowired
    public ListarProdutoAdapter(PedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Pedido pedido) {
        repository.salvarPedido(pedido);
    }
}
