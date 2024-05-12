package com.example.demo.adapter.inbound.controller.request.pedido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequest {

    private Long produtoId;
    private Integer quantidade;

    public PedidoRequest() {
    }

    public PedidoRequest(Long produtoId, Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public boolean isValid() {
        return produtoId != null && quantidade != null;
    }
}