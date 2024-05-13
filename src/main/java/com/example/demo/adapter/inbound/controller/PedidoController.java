package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.response.pedido.PedidoResponse;
import com.example.demo.core.ports.inbound.pedido.ListarPedidosUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    private final ListarPedidosUseCasePort listarPedidosUseCasePort;

    public PedidoController(ListarPedidosUseCasePort listarPedidosUseCasePort) {
        this.listarPedidosUseCasePort = listarPedidosUseCasePort;
    }


    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listarPedidos() {
        final var result = listarPedidosUseCasePort.execute();
        return ResponseEntity.ok().build();
    }
}
