package com.example.demo.adapter.inbound.controller.response.pedido;

import com.example.demo.core.domain.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoCategoriaResponse {

    private Integer totalDeItens;
    private List<ProdutoResponse> itens;

    public ProdutoCategoriaResponse(List<Produto> produtos) {
        this.totalDeItens = produtos.size();
        this.itens = produtos.stream()
                .map(ProdutoResponse::fromDomain)
                .collect(Collectors.toList());
    }

    public static ProdutoCategoriaResponse fromDomain(List<Produto> produtos) {
        return new ProdutoCategoriaResponse(produtos);
    }
}
