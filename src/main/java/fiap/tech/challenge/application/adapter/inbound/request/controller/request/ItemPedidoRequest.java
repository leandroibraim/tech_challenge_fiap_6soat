package fiap.tech.challenge.application.adapter.inbound.request.controller.request;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class ItemPedidoRequest {
    @NotEmpty(message = "O nome não pode ser vazio")
    private String nome;
    @NotEmpty(message = "O preço unitário não pode ser vazia")
    private BigDecimal precoUnitario;
    @NotEmpty(message = "A quantidade não pode ser vazia")
    private Integer quantidade;

    public ItemPedidoRequest() {
    }

    public ItemPedidoRequest(String nome, BigDecimal precoUnitario, int quantidade) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }
}
