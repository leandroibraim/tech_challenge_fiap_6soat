package com.example.demo.adapter.inbound.controller.response.pedido;

import com.example.demo.adapter.inbound.controller.response.produto.ProdutoResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ComposicaoResponse {

    @JsonProperty("id_produto")
    private Long idProduto;
    private int quantidade;

}
