package com.example.demo.adapter.outbound.repository.mapper;

import com.example.demo.adapter.outbound.repository.entity.ClienteEntity;
import com.example.demo.adapter.outbound.repository.entity.ComposicaoEntity;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import com.example.demo.core.domain.Cliente;
import com.example.demo.core.domain.Pedido;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ClienteEntityMapper {

    ClienteEntityMapper INSTANCE = Mappers.getMapper(ClienteEntityMapper.class);

    ClienteEntity mapFrom(Cliente cliente);
}
