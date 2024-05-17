package com.example.demo.adapter.inbound.controller;

import com.example.demo.core.usecase.ListaProdutoUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final ListaProdutoUseCase listaProdutoUseCase;

    public ProdutoController(ListaProdutoUseCase listaProdutoUseCase) {
        this.listaProdutoUseCase = listaProdutoUseCase;
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<?> produto(@PathVariable("produtoId") String produtoId){


        return ResponseEntity.ok().build();

    }
}
