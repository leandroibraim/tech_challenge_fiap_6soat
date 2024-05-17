package com.example.demo.adapter.inbound.controller.response.pedido.mapper;

import com.example.demo.adapter.inbound.controller.response.pedido.ComposicaoResponse;
import com.example.demo.core.domain.Composicao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComposicaoResponseMapper {

    ComposicaoResponseMapper INSTANCE = Mappers.getMapper(ComposicaoResponseMapper.class);

    ComposicaoResponse mapFrom(Composicao composicao);

}
