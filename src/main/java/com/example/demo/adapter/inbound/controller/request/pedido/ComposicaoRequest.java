package com.example.demo.adapter.inbound.controller.request.pedido;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComposicaoRequest {

    private List<ProdutoRequest> produto;
}
