package com.example.demo.adapter.outbound.repository.mapper;

import com.example.demo.adapter.outbound.repository.entity.ComposicaoEntity;
import com.example.demo.core.domain.Composicao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ComposicaoEntityMapper {

    ComposicaoEntityMapper INSTANCE = Mappers.getMapper(ComposicaoEntityMapper.class);

    ComposicaoEntity mapFrom(Composicao composicao);
    List<ComposicaoEntity> mapFrom(List<Composicao> composicao);

}
