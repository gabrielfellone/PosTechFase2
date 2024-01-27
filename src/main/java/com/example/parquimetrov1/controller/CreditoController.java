package com.example.parquimetrov1.controller;

import com.example.parquimetrov1.domain.Carro;
import com.example.parquimetrov1.domain.Credito;
import com.example.parquimetrov1.domain.Parquimetro;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parquimetrov1.service.CreditoService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/credito")
@RequiredArgsConstructor
public class CreditoController {

    private final CreditoService creditoService;

    @PostMapping("criaCredito")
    public ResponseEntity<String> postCredito(@RequestBody Credito request) {
        log.info("Criando credito {}", request);
        creditoService.salvaCredito(request);
        return ResponseEntity.status(CREATED).body("Credito Criado com Sucesso!");
    }
    @GetMapping("listaCreditos")
    public ResponseEntity<List<Credito>> getListaCreditos() {
        log.info("Busca lista de creditos");
        return ResponseEntity.ok(creditoService.getListaCreditos());
    }



}
