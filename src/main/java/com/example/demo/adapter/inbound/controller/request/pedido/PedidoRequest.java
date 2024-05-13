package com.example.demo.adapter.inbound.controller.request.pedido;

import lombok.*;

import java.util.List;

@Data
public class PedidoRequest {

    private ClienteRequest cliente;
    private ComposicaoRequest composicao;
    private Double valorTotal;
}
