package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.request.cliente.ClienteRequest;
import com.example.demo.adapter.inbound.controller.request.cliente.mapper.ClienteMapper;
import com.example.demo.adapter.inbound.controller.response.cliente.mapper.ClienteResponseMapper;
import com.example.demo.core.ports.inbound.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.ports.inbound.cliente.RecuperarClienteUseCasePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/clientes")
@AllArgsConstructor
public class ClienteController {


    private final IncluirClienteUseCasePort incluirClienteUseCasePort;
    private final RecuperarClienteUseCasePort recuperarClienteUseCasePort;

    @PostMapping
    public ResponseEntity<?> incluir(@RequestBody ClienteRequest request){
        incluirClienteUseCasePort.execute(ClienteMapper.INSTANCE.mapFrom(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{documentoCliente}")
    public ResponseEntity recuperar(@PathVariable("documentoCliente") final String documentoCliente) {
        return ResponseEntity.ok()
                        .body(ClienteResponseMapper.INSTANCE.mapFrom(recuperarClienteUseCasePort.execute(documentoCliente)));

    }
}
