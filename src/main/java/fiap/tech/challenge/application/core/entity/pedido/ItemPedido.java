package fiap.tech.challenge.application.core.entity.pedido;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@DynamoDBTable(tableName = "ITENS_PEDIDOS")
public class ItemPedido {
    //   @DynamoDBHashKey(attributeName = "idItem")
    //@DynamoDBAutoGeneratedKey
    @Schema(description = "Identificador único do item após ser criado", example = "1", required = true)
    private String idItem;

    //    @DynamoDBAttribute(attributeName = "idPedido")
    @Schema(description = "Identificador único do pedido ao qual o item está associado", required = true)
    private long idPedido;
    //@DynamoDBAttribute(attributeName = "idProduto")

    //@DynamoDBTypeConverted(converter = ProdutoConverter.class)
    @Schema(description = "Produto relacionado ao item", required = true)
    private Produto produto;

    @NotNull
    @Positive
    //@DynamoDBAttribute(attributeName = "precoUnitario")
    @Schema(description = "Preço unitário do produto", example = "19.00", required = true)
    private BigDecimal precoUnitario;

    @Min(value = 1, message = "A quantidade mínima permitida é 1")
    //@DynamoDBAttribute(attributeName = "quantidade")
    @Schema(description = "Quantidade total do produto", example = "3", required = true)
    private int quantidade;

    @Size(max = 100)
    //@DynamoDBAttribute(attributeName = "observacao")
    @Schema(description = "Observações adicionais fornecidas pelo cliente para este produto", example = "Sem queijo e mostarda", maxLength = 100)
    private String observacao;

    // Getter e Setter para produto omitidos
}