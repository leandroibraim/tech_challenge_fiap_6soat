package com.example.demo.adapter.outbound.repository.mapper;

import com.example.demo.adapter.outbound.repository.entity.ComposicaoEntity;
import com.example.demo.adapter.outbound.repository.entity.PedidoEntity;
import com.example.demo.core.domain.Composicao;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.Produto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = LocalDate.class, uses = ClienteEntityMapper.class)
public interface PedidoEntityMapper {

    PedidoEntityMapper INSTANCE = Mappers.getMapper(PedidoEntityMapper.class);

   @Mapping(target = "dataPedido", expression = "java(LocalDate.now())")
   PedidoEntity mapFrom(Pedido pedido);

   Pedido mapFrom(PedidoEntity pedidoEntity);

    List<Pedido> mapFrom(List<PedidoEntity> pedidoEntity);

   @AfterMapping
   default Pedido afterMapping(@MappingTarget Pedido pedido, PedidoEntity pedidoEntity){

       //TODO Tratar afterMapping

       final var listaComposicao = pedidoEntity.getComposicaoEntity();
       pedido.setComposicao(new Composicao());
       pedido.getComposicao().setProduto(new ArrayList<>());

       listaComposicao.forEach(item -> {
           var produto = new Produto();
           produto.setCategoria(item.getCategoria());
           produto.setNome(item.getNome());
           produto.setValor(item.getValor());
           produto.setQuantidade(item.getQuantidade());

           pedido.getComposicao().getProduto().add(produto);
       });

       return pedido;

   }

   @AfterMapping
   default PedidoEntity afterMapping(@MappingTarget PedidoEntity entity, Pedido pedido){

       //TODO melhorar mapper
       final var listProdutos = pedido.getComposicao().getProduto();

       final var listProdutosEntity = new ArrayList<>();

       var result = listProdutos.stream().map(item -> {
           var composicao = new ComposicaoEntity();

           composicao.setNome(item.getNome());
           composicao.setCategoria(item.getCategoria());
           composicao.setValor(item.getValor());
           composicao.setQuantidade(item.getQuantidade());
           return composicao;
       }).toList();

       entity.setComposicaoEntity(result);

       return entity;

   }


}
