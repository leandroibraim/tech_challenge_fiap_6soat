package com.example.demo.core.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private Long id;
    private Long clienteId;
    private List<ItemPedido> itensPedido;
    private LocalDateTime dataDeCriacao;
    private String totalPedido;

    public Pedido(Long clienteId, List<ItemPedido> itensPedido) {
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
    }

    public Pedido(Long id, Long clienteId, List<ItemPedido> itensPedido, LocalDateTime dataDeCriacao, String totalPedido) {
        this.id = id;
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
        this.dataDeCriacao = dataDeCriacao;
        this.totalPedido = totalPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(String totalPedido) {
        this.totalPedido = totalPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) &&
                Objects.equals(clienteId, pedido.clienteId) &&
                Objects.equals(itensPedido, pedido.itensPedido) &&
                Objects.equals(dataDeCriacao, pedido.dataDeCriacao) &&
                Objects.equals(totalPedido, pedido.totalPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clienteId, itensPedido, dataDeCriacao, totalPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", itensPedido=" + itensPedido +
                ", dataDeCriacao=" + dataDeCriacao +
                ", totalPedido='" + totalPedido + '\'' +
                '}';
    }
}
