package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.request.pagamento.PagamentoRequest;
import com.example.demo.adapter.inbound.controller.request.pagamento.mapper.PagamentoMapper;
import com.example.demo.core.domain.Pagamento;
import com.example.demo.core.ports.inbound.pagamento.PagarPedidoUseCasePort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pagamento")
@AllArgsConstructor
public class PagamentoController {

    private PagarPedidoUseCasePort pagarPedidoUseCasePort;
    private PagamentoMapper pagamentoMapper;

    @PostMapping
    public ResponseEntity<?> realizarPagamento(@RequestBody PagamentoRequest pagamentoRequest) {

        Pagamento pagamento = pagamentoMapper.mapFrom(pagamentoRequest);
        pagarPedidoUseCasePort.checkout(pagamento);

        return ResponseEntity.ok().build();
    }
}
