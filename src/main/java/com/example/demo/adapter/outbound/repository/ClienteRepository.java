package com.example.demo.adapter.outbound.repository;

import com.example.demo.adapter.inbound.controller.response.ClienteDTO;
import com.example.demo.core.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    public void incluir(Cliente cliente);
    public void atualizar(Cliente cliente);
    public void excluir(Cliente cliente);
    public Cliente recuperar(String cpfCliente);

}
