package com.example.demo.adapter.outbound;

import com.example.demo.adapter.outbound.repository.ProdutoRepository;
import com.example.demo.adapter.outbound.repository.entity.ProdutoEntity;
import com.example.demo.adapter.outbound.repository.mapper.ProdutoEntityMapper;
import com.example.demo.core.domain.Produto;
import com.example.demo.core.ports.outbound.produto.GerenciarProdutoAdapterPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GerenciarProdutoAdapter implements GerenciarProdutoAdapterPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public void execute(Produto produto) {
        var produtoEntity = ProdutoEntityMapper.INSTANCE.mapFrom(produto);
        produtoEntity.setStatus(true);
        produtoRepository.save(produtoEntity);
    }

    @Override
    public List<Produto> buscarProdutoPorCategoria(String categoria) {
        return ProdutoEntityMapper.INSTANCE.mapFrom(produtoRepository.findByCategoriaAndStatus(categoria,true));
    }

    @Override
    public void deletarProduto(Long idProduto) {
        Optional<ProdutoEntity> entity = produtoRepository.findById(idProduto);

        if(entity.isPresent()){
            entity.get().setStatus(false);
            produtoRepository.save(entity.get());
        }
    }

    @Override
    public void alterarProduto(Produto produto) {
        Optional<ProdutoEntity> entity = produtoRepository.findById(produto.getIdProduto());

        if(entity.isPresent()){
            var produtoEntity = ProdutoEntityMapper.INSTANCE.mapFrom(produto);
            produtoEntity.setStatus(true);
            produtoRepository.save(produtoEntity);
        }
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        return ProdutoEntityMapper.INSTANCE.mapFrom(produtoRepository.findById(id).get());
    }
}
