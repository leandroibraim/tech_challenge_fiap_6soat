package com.example.demo.core.domain;

import java.util.Objects;

public class ItemPedido {

    private Long produtoId;
    private int quantidade;

    // Construtor
    public ItemPedido(Long produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Sobrescrita dos métodos equals, hashCode e toString para comparação e representação em string
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return quantidade == that.quantidade &&
                Objects.equals(produtoId, that.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoId, quantidade);
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                '}';
    }
}
