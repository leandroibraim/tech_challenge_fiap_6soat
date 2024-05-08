package com.example.demo.adapter.inbound.controller.response.pedido;

import com.example.demo.core.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaResponse {

    private Long id;
    private String nome;

    public CategoriaResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static CategoriaResponse fromDomain(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }

}
