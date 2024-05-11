package com.example.demo.core.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@DynamoDBTable(tableName = "Clientes")
public class Cliente {

    @DynamoDBHashKey(attributeName = "cpf_cliente")
    private String cpf;

    @DynamoDBAttribute(attributeName = "nome_cliente")
    private String nome;

    @DynamoDBAttribute(attributeName = "email_cliente")
    private String email;

    @DynamoDBAttribute(attributeName = "telefone_cliente")
    private String telefone;
}
