package com.example.demo.adapter.inbound.controller.request.pedido.mapper;

import com.example.demo.adapter.inbound.controller.request.pedido.PedidoRequest;
import com.example.demo.core.domain.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {ClienteMapper.class, ProdutoMapper.class, ComposicaoMapper.class})
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    Pedido mapFrom(PedidoRequest pedidoRequest);

}
