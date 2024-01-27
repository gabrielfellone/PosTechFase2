package com.example.parquimetrov1.domain;

import com.example.parquimetrov1.controller.resources.CarroResources;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carro {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private LocalDate dtaInicio;
    private String placa;

    public Carro(Optional<Carro> carro) {
        this.id = carro.get().getId();
        this.dtaInicio = carro.get().getDtaInicio();
        this.placa = carro.get().getPlaca();
    }

    public Carro(CarroResources resources){
        this.id = resources.getId();
        this.dtaInicio = resources.getDtaInicio();
        this.placa = resources.getPlaca();
    }

    public Carro(Carro carro){
        this.id = carro.getId();
        this.dtaInicio = carro.getDtaInicio();
        this.placa = carro.getPlaca();
    }
}
