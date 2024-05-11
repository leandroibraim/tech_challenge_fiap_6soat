package com.example.demo.adapter.inbound.controller;

import com.example.demo.adapter.inbound.controller.response.ClienteDTO;
import com.example.demo.core.usecase.ClienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity incluir(@Valid @RequestBody final ClienteDTO cliente){
        try {
            clienteService.incluir(cliente);
            return ResponseEntity.ok("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping
    public ResponseEntity atualizar(@Valid @RequestBody final ClienteDTO cliente) {
        try {
            clienteService.atualizar(cliente);
            return ResponseEntity.ok("Cadastro do cliente atualizado com sucesso!");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{cpfCliente}")
    public ResponseEntity excluir(@PathVariable("cpfCliente") final String cpfCliente){
        try {
            clienteService.excluir(cpfCliente);
            return ResponseEntity.ok("Cadastro do cliente excluído com sucesso!");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{cpfCliente}")
    public ResponseEntity recuperar(@PathVariable("cpfCliente") final String cpfCliente) {
        try {
            ClienteDTO clienteDTO = clienteService.recuperar(cpfCliente);

            if(clienteDTO == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
