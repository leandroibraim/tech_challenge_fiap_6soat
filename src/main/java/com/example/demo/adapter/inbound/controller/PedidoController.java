package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.response.pedido.PedidoResponse;
import com.example.demo.core.ports.inbound.pedido.ListaPedidosUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final ListaPedidosUseCasePort listaPedidosUseCasePort;

    public PedidoController(ListaPedidosUseCasePort listaPedidosUseCasePort) {
        this.listaPedidosUseCasePort = listaPedidosUseCasePort;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PedidoResponse>> listarPedidos() {
        return ResponseEntity.ok(PedidoResponse.fromDomain(listaPedidosUseCasePort.execute()));
    }
}
