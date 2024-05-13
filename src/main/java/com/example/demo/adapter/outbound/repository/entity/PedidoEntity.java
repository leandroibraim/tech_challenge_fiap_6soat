package com.example.demo.adapter.outbound.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@DynamoDBTable(tableName = "pedido")
public class PedidoEntity {

    @DynamoDBHashKey(attributeName = "numero_pedido")
    private String numeroPedido;

    @DynamoDBRangeKey(attributeName = "data_pedido")
    private String dataPedido;

    @DynamoDBAttribute(attributeName = "status")
    private String status;

    @DynamoDBAttribute(attributeName = "composicao")
    private List<ComposicaoEntity> composicaoEntity;

}
