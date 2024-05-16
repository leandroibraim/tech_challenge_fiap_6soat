package com.example.demo.adapter.outbound.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.adapter.outbound.repository.entity.ClienteEntity;
import com.example.demo.adapter.outbound.repository.mapper.ClienteEntityMapper;
import com.example.demo.core.domain.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class ClienteRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public void incluir(Cliente cliente) {
        dynamoDBMapper.save(ClienteEntityMapper.INSTANCE.mapFrom(cliente));
    }

    public Cliente recuperar(String documentoCliente) {
        ClienteEntity entity = dynamoDBMapper.load(ClienteEntity.class, documentoCliente);
        return ClienteEntityMapper.INSTANCE.mapFrom(entity);
    }
}
