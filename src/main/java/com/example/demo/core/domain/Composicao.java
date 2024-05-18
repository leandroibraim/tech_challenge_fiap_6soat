package com.example.demo.core.domain;

public class Composicao {

    private Long idComposicao;
    private Long idProduto;
    private int quantidade;
    private double precoUnitario;
    private Long numeroPedido;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdComposicao() {
        return idComposicao;
    }

    public void setIdComposicao(Long idComposicao) {
        this.idComposicao = idComposicao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
}
