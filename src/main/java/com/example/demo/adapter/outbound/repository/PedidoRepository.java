package com.example.demo.adapter.outbound.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PedidoRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    private List<PedidoEntity> listarProduto(){

        //dynamoDBMapper.load(PedidoEntity.class, );

        return List.of();
    }





}
