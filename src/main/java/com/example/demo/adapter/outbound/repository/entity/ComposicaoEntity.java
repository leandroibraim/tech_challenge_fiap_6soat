package com.example.demo.adapter.outbound.repository.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBDocument
public class ComposicaoEntity {


    @DynamoDBAttribute(attributeName = "categoria")
    private String categoria;

    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @DynamoDBAttribute(attributeName = "quantidade")
    private String quantidade;

    @DynamoDBAttribute(attributeName = "valor")
    private String valor;

}
