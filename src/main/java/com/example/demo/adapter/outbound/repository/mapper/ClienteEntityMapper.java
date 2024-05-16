package com.example.demo.adapter.outbound.repository.mapper;

import com.example.demo.adapter.outbound.repository.entity.ClienteEntity;
import com.example.demo.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteEntityMapper {

    ClienteEntityMapper INSTANCE = Mappers.getMapper(ClienteEntityMapper.class);

    ClienteEntity mapFrom(Cliente cliente);

    Cliente mapFrom(ClienteEntity clienteEntity);
}
