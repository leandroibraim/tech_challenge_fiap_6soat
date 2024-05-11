package com.example.demo.adapter.outbound.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.adapter.inbound.controller.response.ClienteDTO;
import com.example.demo.core.domain.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {


    private AmazonDynamoDB dynamoClient; //= AmazonDynamoDBClientBuilder.standard().build();
    private DynamoDBMapper dynamoMapper;

    public ClienteRepositoryImpl(AmazonDynamoDB dynamoClient) {
        this.dynamoClient = dynamoClient;
        dynamoMapper = new DynamoDBMapper(dynamoClient);
    }

    @Override
    public void incluir(Cliente cliente) {
        dynamoMapper.save(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        dynamoMapper.save(cliente);
    }

    @Override
    public void excluir(Cliente cliente) {
        dynamoMapper.delete(cliente);
    }

    @Override
    public Cliente recuperar(String cpfCliente) {
        return dynamoMapper.load(Cliente.class, cpfCliente);
    }
}
