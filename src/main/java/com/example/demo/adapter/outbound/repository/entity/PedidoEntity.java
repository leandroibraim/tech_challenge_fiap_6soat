package com.example.demo.adapter.outbound.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_pedido")
@Getter
@Setter
public class PedidoEntity {

    @Id
    @Column(name = "numero_pedido")
    private Long numeroPedido;

    @Column(name = "data_pedido")
    private String dataPedido;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "etapa")
    private String etapa;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ComposicaoEntity> composicao;



}
