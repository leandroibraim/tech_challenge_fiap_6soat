package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.request.PedidoRequest;
import com.example.demo.adapter.inbound.controller.response.pedido.PedidoResponse;
import com.example.demo.core.ports.inbound.pedido.ListaPedidosUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final ListaPedidosUseCasePort listaPedidosUseCasePort;

    public PedidoController(ListaPedidosUseCasePort listaPedidosUseCasePort) {
        this.listaPedidosUseCasePort = listaPedidosUseCasePort;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PedidoResponse>> listarTodosPedidos() {
        return ResponseEntity.ok(PedidoResponse.fromDomain(listaPedidosUseCasePort.execute()));
    }

    @PostMapping
    public ResponseEntity<Void> criarPedido(@Valid @RequestBody PedidoRequest pedidoRequest) {
        if (pedidoRequest.isValid()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}