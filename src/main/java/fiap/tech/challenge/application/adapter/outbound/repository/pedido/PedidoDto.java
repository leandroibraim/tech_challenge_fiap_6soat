package fiap.tech.challenge.application.adapter.outbound.repository.pedido;

import fiap.tech.challenge.application.core.entity.pedido.Pago;
import fiap.tech.challenge.application.core.entity.pedido.StatusPedido;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDto {
    private Long id;
    private String descricao;
    private BigDecimal valorTotal;
    private List<ItemPedidoDto> itens;
    private StatusPedido status;
    private Pago pago;

    public PedidoDto() {
    }

    public PedidoDto(Long id, String descricao, BigDecimal valorTotal, List<ItemPedidoDto> itens, StatusPedido status, Pago pago) {
        this.id = id;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.status = status;
        this.pago = pago;
    }

}

class ItemPedidoDto {
    private String nome;
    private BigDecimal precoUnitario;
    private int quantidade;

    public ItemPedidoDto() {
    }

    public ItemPedidoDto(String nome, BigDecimal precoUnitario, int quantidade) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

}
