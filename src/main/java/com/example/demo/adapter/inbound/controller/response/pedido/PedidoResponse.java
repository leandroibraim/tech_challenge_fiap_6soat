package com.example.demo.adapter.inbound.controller.response.pedido;

import com.example.demo.core.domain.ItemPedido;
import com.example.demo.core.domain.Pedido;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PedidoResponse {

    private Long id;
    private Long clienteId;
    private List<ItemPedido> itensPedido;
    private BigDecimal totalPedido;

    public PedidoResponse(Long id, Long clienteId, List<ItemPedido> itensPedido, BigDecimal totalPedido) {
        this.id = id;
        this.clienteId = clienteId;
        this.itensPedido = itensPedido;
        this.totalPedido = totalPedido;
    }

    public static PedidoResponse fromDomain(Pedido pedido) {
        return new PedidoResponse(
                pedido.getId(),
                pedido.getClienteId(),
                pedido.getItensPedido(),
                new BigDecimal(pedido.getTotalPedido())
        );
    }

    public static List<PedidoResponse> fromDomain(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(pedido -> new PedidoResponse(
                        pedido.getId(),
                        pedido.getClienteId(),
                        pedido.getItensPedido(),
                        new BigDecimal(pedido.getTotalPedido())))
                .collect(Collectors.toList());
    }
}