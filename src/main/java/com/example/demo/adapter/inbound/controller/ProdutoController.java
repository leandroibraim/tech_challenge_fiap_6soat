package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.request.ProdutoRequest;
import com.example.demo.adapter.inbound.controller.response.pedido.ProdutoResponse;
import com.example.demo.core.ports.inbound.produto.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final CriaProdutoUseCasePort criaProdutoUseCasePort;
    private final RecuperaProdutoUseCasePort recuperaProdutoUseCasePort;
    private final AtualizaProdutoUseCasePort atualizaProdutoUseCasePort;
    private final DeletaProdutoUseCasePort deletaProdutoUseCasePort;

    public ProdutoController(CriaProdutoUseCasePort criaProdutoUseCasePort,
                             RecuperaProdutoUseCasePort recuperaProdutoUseCasePort,
                             AtualizaProdutoUseCasePort atualizaProdutoUseCasePort,
                             DeletaProdutoUseCasePort deletaProdutoUseCasePort) {
        this.criaProdutoUseCasePort = criaProdutoUseCasePort;
        this.recuperaProdutoUseCasePort = recuperaProdutoUseCasePort;
        this.atualizaProdutoUseCasePort = atualizaProdutoUseCasePort;
        this.deletaProdutoUseCasePort = deletaProdutoUseCasePort;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(ProdutoResponse.fromDomain(criaProdutoUseCasePort.execute(produtoRequest.toDomain())));
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponse> atualizarProduto(@PathVariable Long produtoId, @Valid @RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(ProdutoResponse.fromDomain(atualizaProdutoUseCasePort.execute(produtoRequest.toDomain(produtoId))));
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long produtoId) {
        deletaProdutoUseCasePort.execute(produtoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponse> recuperarProdutoPorId(@PathVariable Long produtoId) {
        return ResponseEntity.ok(ProdutoResponse.fromDomain(recuperaProdutoUseCasePort.execute(produtoId)));
    }

}
