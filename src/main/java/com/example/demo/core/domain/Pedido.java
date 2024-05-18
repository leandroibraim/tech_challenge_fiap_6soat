package com.example.demo.core.domain;

import java.util.List;

public class Pedido {

    private Long numeroPedido;
    private Cliente cliente;
    private Double valorTotal;
    private List<Composicao> composicao;
    private String status;
    private String etapa;

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Composicao> getComposicao() {
        return composicao;
    }

    public void setComposicao(List<Composicao> composicao) {
        this.composicao = composicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }
}
