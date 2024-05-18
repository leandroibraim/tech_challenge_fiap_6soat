package com.example.demo.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Composicao {

    private Long idComposicao;
    private Long idProduto;
    private int quantidade;
    private double precoUnitario;
    private Long numeroPedido;

}
