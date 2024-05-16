package com.example.demo.adapter.outbound.repository;

import com.example.demo.core.domain.Cliente;
import com.example.demo.core.ports.outbound.cliente.IncluirClienteAdapterPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class IncluirClienteAdapter implements IncluirClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    @Override
    public void execute(Cliente cliente) {
        clienteRepository.incluir(cliente);
    }
}
