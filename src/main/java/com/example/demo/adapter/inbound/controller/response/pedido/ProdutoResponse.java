package com.example.demo.adapter.inbound.controller.response.pedido;

import com.example.demo.core.domain.Produto;

public class ProdutoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private String valor;
    private CategoriaResponse categoria;

    public ProdutoResponse(Long id, String nome, String descricao, String valor, CategoriaResponse categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public static ProdutoResponse fromDomain(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor().toString(),
                CategoriaResponse.fromDomain(produto.getCategoria())
        );
    }
}
