package com.example.demo.adapter.inbound.controller.response.pedido;

import com.example.demo.core.domain.Produto;

import java.math.BigDecimal;

public class ProdutoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;

    public ProdutoResponse(Long id, String nome, String descricao, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static ProdutoResponse fromDomain(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor()
        );
    }
}