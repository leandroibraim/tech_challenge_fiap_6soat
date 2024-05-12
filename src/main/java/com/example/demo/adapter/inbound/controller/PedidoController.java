package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.response.pedido.PedidoResponse;
import com.example.demo.core.usecase.ListarPedidosUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final ListarPedidosUseCase listaPedidosUseCase;

    public PedidoController(ListarPedidosUseCase listaPedidosUseCasePort) {
        this.listaPedidosUseCase = listaPedidosUseCasePort;
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listaPedidos() {
        final var result = listaPedidosUseCase.execute();

        return ResponseEntity.ok().build();
    }
}
