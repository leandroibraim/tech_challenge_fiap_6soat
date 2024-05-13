package com.example.demo.adapter.outbound.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Repository
public class PedidoRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public PedidoRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public List<PedidoEntity> listarPedidosPorStatus(final String status, final LocalDateTime localDateTime){
        final HashMap<String, AttributeValue> mapAttr = new HashMap<>();

        mapAttr.put(":status", new AttributeValue().withS("status"));
        mapAttr.put(":data", new AttributeValue().withS(""));

        final DynamoDBQueryExpression<PedidoEntity> queryExpression = new DynamoDBQueryExpression<PedidoEntity>()
                .withIndexName("gsi_status")
                .withKeyConditionExpression("status = :status and data_pedido = :data_pedido")
                .withExpressionAttributeValues(mapAttr);

        final PaginatedQueryList<PedidoEntity> queryList = dynamoDBMapper.query(PedidoEntity.class, queryExpression);


        dynamoDBMapper.load(PedidoEntity.class);
        return List.of();
    }

}
