package com.example.demo.adapter.inbound.controller.request;

import java.math.BigDecimal;

import com.example.demo.core.domain.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {

    private String nome;
    private String descricao;
    private String valor;

    public Produto toDomain() {
        return new Produto(nome, descricao, new BigDecimal(valor));
    }

    public Produto toDomain(Long id) {
        return new Produto(id, nome, descricao, new BigDecimal(valor));
    }

    public boolean isValid() {
        return nome != null && !nome.trim().isEmpty() &&
                descricao != null && !descricao.trim().isEmpty() &&
                valor != null && !valor.trim().isEmpty() && valor.matches("\\d+(\\.\\d+)?");
    }
}