package com.example.demo.adapter.inbound.controller.response.pedido;

import com.example.demo.adapter.inbound.controller.response.ClienteResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private ClienteResponse cliente;
    private List<ItemPedidoResponse> composicao;
    private String valor;
    private String status;

}
