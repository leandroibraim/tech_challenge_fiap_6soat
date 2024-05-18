package com.example.demo.adapter.outbound.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import com.example.demo.core.domain.Pedido;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Repository
public class PedidoRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public PedidoRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public List<PedidoEntity> listarPedidosPorStatus(final String status, final LocalDate localDate){
        final HashMap<String, AttributeValue> mapAttr = new HashMap<>();

        mapAttr.put(":status_pedido", new AttributeValue().withS(status));
        mapAttr.put(":data_pedido", new AttributeValue().withS(localDate.toString()));

        final DynamoDBQueryExpression<PedidoEntity> queryExpression = new DynamoDBQueryExpression<PedidoEntity>()
                .withIndexName("gsi_status_pedido")
                .withKeyConditionExpression("status_pedido = :status_pedido and data_pedido = :data_pedido")
                .withExpressionAttributeValues(mapAttr)
                .withConsistentRead(false);

        final PaginatedQueryList<PedidoEntity> queryList = dynamoDBMapper.query(PedidoEntity.class, queryExpression);

        return queryList.stream().toList();
    }

    public void salvarPedido(Pedido pedido){
        dynamoDBMapper.save(PedidoEntityMapper.INSTANCE.mapFrom(pedido));
    }

}
