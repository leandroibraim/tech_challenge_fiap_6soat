package com.example.demo.adapter.inbound.controller.request.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class PedidoRequest {

    @JsonProperty("id_cliente")
    private Long idCliente;

    private List<ComposicaoRequest> composicao;


}
