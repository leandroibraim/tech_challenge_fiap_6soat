package com.example.demo.adapter.inbound.controller.request.pedido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {

    private String nome;
    private String quantidade;
    private String categoria;
    private Double valor;
}
