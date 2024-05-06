package fiap.tech.challenge.application.core.entity.pedido;

public enum Pago {
    NAO("Não"),
    SIM("Sim");

    private final String descricao;

    Pago(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
