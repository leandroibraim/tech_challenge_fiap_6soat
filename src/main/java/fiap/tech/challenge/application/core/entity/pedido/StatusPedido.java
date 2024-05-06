package fiap.tech.challenge.application.core.entity.pedido;

public enum StatusPedido {
    RECEBIDO("Recebido"),
    PREPARACAO("Em preparação"),
    PRONTO("Pronto para entrega"),
    FINALIZADO("Pedido entregue"),
    CANCELADO("Pedido cancelado");

    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean estaProntoParaEntrega() {
        return this == PRONTO;
    }

    public boolean estaCancelado() {
        return this == CANCELADO;
    }

    public boolean estaRecebido() {
        return this == RECEBIDO;
    }

    public boolean estaEmPreparacao() {
        return this == PREPARACAO;
    }

    public boolean estaFinalizado() {
        return this == FINALIZADO;
    }
}
