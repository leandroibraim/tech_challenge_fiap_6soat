package com.example.demo.adapter.inbound.controller.request.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {

    private Long produtoId;
    private Integer quantidade;

}
