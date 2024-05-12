package com.example.demo.adapter.inbound.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TesteController {
    @GetMapping
    private ResponseEntity<?> testeController(){
        return ResponseEntity.ok("Hello");
    }

}
