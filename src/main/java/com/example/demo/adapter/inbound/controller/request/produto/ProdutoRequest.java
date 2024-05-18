package com.example.demo.adapter.inbound.controller.request.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {

    @JsonProperty("id_produto")
    private Long idProduto;
    private String nome;
    private String quantidade;
    private String categoria;
    private Double valor;
}
