package fiap.tech.challenge.application.adapter.outbound.repository.pedido;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Produtos")
public class ProdutoDto {

    private String idProduto;
    //  private Categoria categoria;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int tempoPreparo;
    private String imagem;

    //  @DynamoDBHashKey(attributeName = "idProduto")
    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    //   @DynamoDBAttribute(attributeName = "categoria")
    //  public Categoria getCategoria() {
    //      return categoria;
    //  }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @DynamoDBAttribute(attributeName = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @DynamoDBAttribute(attributeName = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @DynamoDBAttribute(attributeName = "preco")
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @DynamoDBAttribute(attributeName = "tempoPreparo")
    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    @DynamoDBAttribute(attributeName = "imagem")
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public ProdutoDto(String idProduto, Categoria categoria, String nome, String descricao, BigDecimal preco, int tempoPreparo, String imagem) {
        this.idProduto = idProduto;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tempoPreparo = tempoPreparo;
        this.imagem = imagem;
    }

    public ProdutoDto() {
    }
}
