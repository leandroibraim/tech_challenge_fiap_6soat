package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.request.pedido.PedidoRequest;
import com.example.demo.adapter.inbound.controller.response.pedido.PedidoResponse;
import com.example.demo.core.ports.inbound.pedido.ListarPedidosUseCasePort;
import com.example.demo.core.ports.inbound.pedido.SalvarPedidoUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    private final ListarPedidosUseCasePort listarPedidosUseCasePort;
    private final SalvarPedidoUseCasePort salvarPedidoUseCasePort;

    public PedidoController(ListarPedidosUseCasePort listarPedidosUseCasePort,
                            SalvarPedidoUseCasePort salvarPedidoUseCasePort) {
        this.listarPedidosUseCasePort = listarPedidosUseCasePort;
        this.salvarPedidoUseCasePort = salvarPedidoUseCasePort;
    }


    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listarPedidos() {
        final var result = listarPedidosUseCasePort.execute();
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> salvarPedido(PedidoRequest request) {
        salvarPedidoUseCasePort.execute(null);
        return ResponseEntity.ok().build();
    }
}
