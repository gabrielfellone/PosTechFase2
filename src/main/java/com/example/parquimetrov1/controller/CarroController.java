package com.example.parquimetrov1.controller;

import com.example.parquimetrov1.controller.resources.CarroResources;
import com.example.parquimetrov1.domain.Carro;
import com.example.parquimetrov1.service.CarroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/v1/carro")
@RequiredArgsConstructor
public class CarroController {

    private final CarroService carroService;
    @PostMapping("solicitarParquimetro")
    public ResponseEntity<String> postAlugaCarro(@RequestBody CarroResources request) {
        log.info("Solicitando parquimetro {}", request);
        Carro carro = carroService.solicitaParquimetro(request);
        return ResponseEntity.status(CREATED).body("Parquimetro solicitado com sucesso com duração até " + carro.getDtaInicio().toString());
    }

    @PostMapping("salvarCarro")
    public ResponseEntity<String> postCarro(@RequestBody CarroResources request) {
        log.info("Salvando Carro na Base {}", request);
        Carro carro = new Carro(request);
        carroService.salvaCarro(carro);
        return ResponseEntity.status(CREATED).body("Carro salvo solicitado com sucesso");
    }
    @GetMapping("listaCarros")
    public ResponseEntity<List<Carro>> getListaCarros() {
        log.info("Busca lista de carros");
        return ResponseEntity.ok(carroService.getListaCarros());
    }

    @GetMapping("getCarroPorId")
    public ResponseEntity<Carro> getCarroPorId(@RequestParam(value = "id", required = true) Long id){
        log.info("Busca Carro Por Id {}", id);
        return ResponseEntity.ok(carroService.getCarroById(id));
    }

}
