package com.example.demo.core.usecase;

import com.example.demo.core.domain.Produto;
import com.example.demo.core.ports.inbound.produto.GerenciarProdutoUseCasePort;
import com.example.demo.core.ports.outbound.produto.GerenciarProdutoAdapterPort;

import java.util.List;

public class GerenciarProdutoUseCase implements GerenciarProdutoUseCasePort {

    private final GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort;

    public GerenciarProdutoUseCase(GerenciarProdutoAdapterPort gerenciarProdutoAdapterPort) {
        this.gerenciarProdutoAdapterPort = gerenciarProdutoAdapterPort;
    }

    @Override
    public void execute(Produto produto) {
        gerenciarProdutoAdapterPort.execute(produto);
    }

    @Override
    public List<Produto> buscarProdutoPorCategoria(String categoria) {
        return gerenciarProdutoAdapterPort.buscarProdutoPorCategoria(categoria);
    }

    @Override
    public void deletarProduto(Long idProduto) {
        gerenciarProdutoAdapterPort.deletarProduto(idProduto);
    }

    @Override
    public void alterarProduto(Produto produto) {
        gerenciarProdutoAdapterPort.alterarProduto(produto);
    }
}
