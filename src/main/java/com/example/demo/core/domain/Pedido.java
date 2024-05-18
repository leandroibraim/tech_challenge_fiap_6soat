package com.example.demo.core.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pedido {

    private Long numeroPedido;
    private Cliente cliente;
    private Double valorTotal;
    private List<Composicao> composicao;
    private String status;

}
