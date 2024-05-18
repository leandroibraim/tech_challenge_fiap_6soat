package com.example.demo.adapter.inbound.controller.response.pedido;

import com.example.demo.adapter.inbound.controller.response.produto.ProdutoResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComposicaoResponse {

    private List<ProdutoResponse> produto;

}
