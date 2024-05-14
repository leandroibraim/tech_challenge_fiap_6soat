package com.example.demo.adapter.inbound.controller.request.pedido;

import lombok.*;

@Getter
@Setter
public class PedidoRequest {

    private ClienteRequest cliente;
    private ComposicaoRequest composicao;
    private Double valorTotal;
}
