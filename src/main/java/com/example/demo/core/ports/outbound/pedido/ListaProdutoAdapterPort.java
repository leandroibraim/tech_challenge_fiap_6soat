package com.example.demo.core.ports.outbound.pedido;

import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.Produto;

import java.util.List;

public interface ListaProdutoAdapterPort {

    List<Produto> execute();
}
