package com.example.demo.adapter.outbound.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@DynamoDBTable(tableName = "ProductInfo")
public class PedidoEntity {


    @DynamoDBHashKey(attributeName = "numero_pedido")
    private String numeroPedido;

    @DynamoDBRangeKey(attributeName = "status_pedido")
    private String statusPedido;

    @DynamoDBAttribute(attributeName = "data_pedido")
    private LocalDateTime dataPedido;

}
