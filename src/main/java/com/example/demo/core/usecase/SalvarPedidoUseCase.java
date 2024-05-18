package com.example.demo.core.usecase;

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
            listProduto.add(
                    gerenciarProdutoAdapterPort.buscarProdutoPorId(item.getIdProduto()));
        });

        var valorTotal = 0.0;

        for(Produto produto : listProduto){
            valorTotal += produto.getValor();
        }

        pedido.setValorTotal(valorTotal);

        salvarPedidoAdapterPort.execute(pedido);
    }

}
