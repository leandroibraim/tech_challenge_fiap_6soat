package com.example.demo.adapter.outbound.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import com.example.demo.adapter.outbound.repository.entity.ProdutoEntity;
import com.example.demo.adapter.outbound.repository.mapper.PedidoEntityMapper;
import com.example.demo.core.domain.Pedido;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProdutoRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public ProdutoRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public List<ProdutoEntity> listarPedidosPorStatus(final String categoria){
        final HashMap<String, AttributeValue> mapAttr = new HashMap<>();

        mapAttr.put(":categoria", new AttributeValue().withS(categoria));

        final DynamoDBQueryExpression<ProdutoEntity> queryExpression = new DynamoDBQueryExpression<ProdutoEntity>()
                .withIndexName("gsi_categoria")
                .withKeyConditionExpression("status_pedido = :status_categoria")
                .withExpressionAttributeValues(mapAttr)
                .withConsistentRead(false);

        final PaginatedQueryList<ProdutoEntity> queryList = dynamoDBMapper.query(ProdutoEntity.class, queryExpression);

        return queryList.stream().toList();
    }

}
