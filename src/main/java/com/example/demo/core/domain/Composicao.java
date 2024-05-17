package com.example.demo.core.domain;
import java.util.List;

public class Composicao {

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    private List<Produto> produto;

}
