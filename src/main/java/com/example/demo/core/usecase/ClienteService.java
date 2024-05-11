package com.example.demo.core.usecase;

import com.example.demo.adapter.inbound.controller.response.ClienteDTO;

import java.util.List;

public interface ClienteService {

    public void incluir(ClienteDTO clienteDTO);
    public void atualizar(ClienteDTO clienteDTO);
    public void excluir(String cpfCliente);
    public ClienteDTO recuperar(String cpfCliente);

}
