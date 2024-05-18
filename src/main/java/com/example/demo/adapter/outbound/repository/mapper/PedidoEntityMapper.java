package com.example.demo.adapter.outbound.repository.mapper;

import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import com.example.demo.core.domain.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ComposicaoEntityMapper.class)
public interface PedidoEntityMapper {

    PedidoEntityMapper INSTANCE = Mappers.getMapper(PedidoEntityMapper.class);

    PedidoEntity mapFrom(Pedido pedido);

}
