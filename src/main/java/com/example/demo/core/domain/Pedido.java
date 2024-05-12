package com.example.demo.core.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private Long numeroPedido;
    private Cliente cliente;
    private LocalDateTime dataPedido;
    private String valor;
    private List<ItemPedido> composicao;
    private String status;

    public Pedido(Long numeroPedido, Cliente cliente, LocalDateTime dataPedido, String valor, List<ItemPedido> composicao, String status) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.valor = valor;
        this.composicao = composicao;
        this.status = status;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<ItemPedido> getComposicao() {
        return composicao;
    }

    public void setComposicao(List<ItemPedido> composicao) {
        this.composicao = composicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
