package com.example.demo.adapter.inbound.controller.request.pedido;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest {

    private String nome;
    private String documento;

}
