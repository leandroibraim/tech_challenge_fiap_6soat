package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Cliente;
import com.example.demo.core.ports.outbound.cliente.RecuperarClienteAdapterPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RecuperarClienteAdapter implements RecuperarClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente execute(String documentoCliente) {
        return clienteRepository.recuperar(documentoCliente);
    }
}
