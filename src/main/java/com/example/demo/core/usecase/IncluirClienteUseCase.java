package com.example.demo.core.usecase;

import com.example.demo.core.domain.Cliente;
import com.example.demo.core.ports.inbound.cliente.IncluirClienteUseCasePort;
import com.example.demo.core.ports.outbound.cliente.IncluirClienteAdapterPort;
import lombok.AllArgsConstructor;

public class IncluirClienteUseCase implements IncluirClienteUseCasePort {

    private final IncluirClienteAdapterPort incluirClienteAdapterPort;

    public IncluirClienteUseCase(IncluirClienteAdapterPort incluirClienteAdapterPort) {
        this.incluirClienteAdapterPort = incluirClienteAdapterPort;
    }

    @Override
    public void execute(Cliente cliente) {
        incluirClienteAdapterPort.execute(cliente);
    }
}
