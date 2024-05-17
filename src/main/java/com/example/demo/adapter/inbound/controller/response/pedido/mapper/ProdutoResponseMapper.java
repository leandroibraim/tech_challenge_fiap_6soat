package com.example.demo.adapter.inbound.controller.response.pedido.mapper;

import com.example.demo.adapter.inbound.controller.response.pedido.ProdutoResponse;
import com.example.demo.core.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoResponseMapper {

    ProdutoResponseMapper INSTANCE = Mappers.getMapper(ProdutoResponseMapper.class);

    ProdutoResponse mapFrom(Produto produto);



}
