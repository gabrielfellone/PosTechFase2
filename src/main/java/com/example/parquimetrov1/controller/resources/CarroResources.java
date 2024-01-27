package com.example.parquimetrov1.controller.resources;

import com.example.parquimetrov1.domain.Carro;
import com.example.parquimetrov1.domain.Credito;
import com.example.parquimetrov1.domain.Parquimetro;
import com.example.parquimetrov1.domain.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
public class CarroResources {

    private Long id;
    private LocalDate dtaInicio;
    private String placa;
    private Long id_parquimetro;
    private Long id_credito;

    public CarroResources(Carro carro,
                          Parquimetro parquimetro,
                          Credito credito) {
        this.id = carro.getId();
        this.dtaInicio = carro.getDtaInicio();
        this.placa = carro.getPlaca();
        this.id_parquimetro = parquimetro.getId();
        this.id_credito = credito.getId();
    }
}
