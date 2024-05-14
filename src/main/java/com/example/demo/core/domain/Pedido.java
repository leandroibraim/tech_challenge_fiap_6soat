package com.example.demo.core.domain;


public class Pedido {

    private String numeroPedido;
    private Cliente cliente;
    private String valorTotal;
    private Composicao composicao;
    private String status;

    public Pedido(String numeroPedido, Cliente cliente, String valorTotal, Composicao composicao, String status) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.composicao = composicao;
        this.status = status;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
