package com.example.demo.adapter.inbound.controller.response.pedido;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoResponse {

    private String numeroPedido;
    private ClienteResponse cliente;
    private ComposicaoResponse composicao;
    private String valorTotal;
    private String status;

}
