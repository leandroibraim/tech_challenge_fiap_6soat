package com.example.demo.adapter.inbound.controller.request.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoRequest {

    @JsonProperty("numero_pedido")
    private Long numeroPedido;

    @JsonProperty("tipo_do_pagamento")
    private String tipoDoPagamento;

}
