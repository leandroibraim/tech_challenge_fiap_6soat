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
    public void salvar(Produto produto) {
        produto.setStatus(true);
        gerenciarProdutoAdapterPort.salvar(produto);
    }

    @Override
    public List<Produto> buscarProdutoPorCategoria(String categoria) {
        return gerenciarProdutoAdapterPort.buscarProdutoPorCategoria(categoria);
    }

    @Override
    public void deletarProduto(Long idProduto) {
        var produto = gerenciarProdutoAdapterPort.buscarProdutoPorId(idProduto);
        produto.setStatus(false);

        gerenciarProdutoAdapterPort.salvar(produto);
    }

    @Override
    public void alterarProduto(Produto produto) {
        produto.setStatus(true);
        gerenciarProdutoAdapterPort.salvar(produto);
    }
}
