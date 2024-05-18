package com.example.demo.core.usecase;

import com.example.demo.core.domain.Cliente;
import com.example.demo.core.ports.inbound.cliente.RecuperarClienteUseCasePort;
import com.example.demo.core.ports.outbound.cliente.RecuperarClienteAdapterPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RecuperarClienteUseCase implements RecuperarClienteUseCasePort {

    private final RecuperarClienteAdapterPort recuperarClienteAdapterPort;

    @Override
    public Cliente execute(String documentoCliente) {
        return recuperarClienteAdapterPort.execute(documentoCliente);
    }
}
