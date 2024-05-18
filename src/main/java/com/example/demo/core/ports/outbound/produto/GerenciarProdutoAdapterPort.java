package com.example.demo.core.ports.outbound.produto;

import com.example.demo.core.domain.Produto;

import java.util.List;

public interface GerenciarProdutoAdapterPort {
    void execute(Produto produto);
    List<Produto> buscarProdutoPorCategoria(String categoria);
    void deletarProduto(Long idProduto);
    void alterarProduto(Produto produto);
    Produto buscarProdutoPorId(Long id);
}
