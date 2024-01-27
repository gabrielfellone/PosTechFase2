package com.example.parquimetrov1.controller;

import com.example.parquimetrov1.controller.resources.ParquimetroResources;
import com.example.parquimetrov1.domain.Parquimetro;
import com.example.parquimetrov1.service.ParquimetroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/parquimetro")
@RequiredArgsConstructor
public class ParquimetroController {

    private final ParquimetroService parquimetroService;

    @GetMapping("listaParquimetros")
    public ResponseEntity<List<ParquimetroResources>> getListaParquimetros(){
        log.info("Busca lista de parquimetros");
        return ResponseEntity.ok(parquimetroService.getListaParquimetros());
    }

    @PostMapping("criarParquimetro")
    public ResponseEntity<String> postAlugaCarro(@RequestBody Parquimetro request) {
        log.info("Criando parquimetro {}", request);
        parquimetroService.salvaParquimetro(request);
        return ResponseEntity.status(CREATED).body("Parquimetro Criado com Sucesso!");
    }

    @GetMapping("buscaParquimetroPorId")
    public ResponseEntity<ParquimetroResources> getParquimetroById(@RequestParam(value = "id", required = true) Long id){
        log.info("Busca Parquimetro Por Id {}", id);
        return ResponseEntity.ok(parquimetroService.getParquimetro(id));
    }

}
