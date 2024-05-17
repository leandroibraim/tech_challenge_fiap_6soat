package com.example.demo.core.usecase;

import com.example.demo.core.ports.outbound.pedido.ListaProdutoAdapterPort;

import java.util.List;

public class ListaProdutoUseCase implements ListaProdutoAdapterPort {
    @Override
    public List<?> listaProduto() {
        return List.of();
    }
}
