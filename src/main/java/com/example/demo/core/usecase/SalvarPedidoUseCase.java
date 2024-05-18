package com.example.demo.core.usecase;

import com.example.demo.core.domain.Composicao;
import com.example.demo.core.domain.Pedido;
import com.example.demo.core.domain.Produto;
import com.example.demo.core.ports.inbound.pedido.SalvarPedidoUseCasePort;
import com.example.demo.core.ports.outbound.pedido.SalvarPedidoAdapterPort;
import com.example.demo.core.ports.outbound.produto.GerenciarProdutoAdapterPort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SalvarPedidoUseCase implements SalvarPedidoUseCasePort {

    private final SalvarPedidoAdapterPort salvarPedidoAdapterPort;
    private final GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort;

    public SalvarPedidoUseCase(SalvarPedidoAdapterPort salvarPedidoAdapterPort, GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort) {
        this.salvarPedidoAdapterPort = salvarPedidoAdapterPort;
        this.gerenciarProdutoAdapterPort = gerenciarProdutoAdapterPort;
    }

    @Override
    public void execute(Pedido pedido) {

        List<Produto> listProduto = new ArrayList<>();

        pedido.getComposicao().forEach(item -> {
            var auxProduto = gerenciarProdutoAdapterPort.buscarProdutoPorId(item.getIdProduto());
            item.setPrecoUnitario(auxProduto.getValor());
            item.setIdProduto(auxProduto.getIdProduto());
        });

        double valorTotal = 0.0;

        for(Composicao composicao : pedido.getComposicao()){
            valorTotal += composicao.getQuantidade() * composicao.getPrecoUnitario();
        }

        pedido.setValorTotal(valorTotal);
        pedido.setEtapa("RECEBIDO");

        salvarPedidoAdapterPort.execute(pedido);
    }

}
