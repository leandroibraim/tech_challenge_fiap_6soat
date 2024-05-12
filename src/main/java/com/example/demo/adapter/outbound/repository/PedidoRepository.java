package com.example.demo.adapter.outbound.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public PedidoRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public List<PedidoEntity> listarProduto(){
        return List.of(dynamoDBMapper.load(PedidoEntity.class, ""));
    }





}
