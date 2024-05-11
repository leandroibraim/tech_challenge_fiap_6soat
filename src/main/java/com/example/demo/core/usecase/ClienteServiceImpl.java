package com.example.demo.core.usecase;

import com.example.demo.adapter.inbound.controller.response.ClienteDTO;
import com.example.demo.adapter.outbound.repository.ClienteRepository;
import com.example.demo.core.domain.Cliente;
import com.example.demo.core.domain.mappers.ClienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    private ClienteMapper clienteMapper;

    @Override
    public void incluir(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.mapFrom(clienteDTO);
        clienteRepository.incluir(cliente);
    }

    @Override
    public void atualizar(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.mapFrom(clienteDTO);
        clienteRepository.atualizar(cliente);

    }

    @Override
    public void excluir(String cpfCliente) {
        Cliente cliente = Cliente.builder()
                .cpf(cpfCliente)
                .build();

        clienteRepository.excluir(cliente);
    }

    @Override
    public ClienteDTO recuperar(String cpfCliente) {
        Cliente cliente = Cliente.builder()
                .cpf(cpfCliente)
                .build();

        cliente = clienteRepository.recuperar(cpfCliente);

        return clienteMapper.mapFrom(cliente);
    }
}
