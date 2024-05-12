package com.example.demo.adapter.outbound.repository;

import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import com.example.demo.core.domain.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    Pedido mapFrom(PedidoEntity source);

    List<Pedido> mapFrom(List<PedidoEntity> source);

}
