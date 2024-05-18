package com.example.demo.adapter.inbound.controller.request.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ComposicaoRequest {

    @JsonProperty("id_produto")
    private Long idProduto;

    private int quantidade;

}
