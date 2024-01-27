package com.example.parquimetrov1.domain;

import com.example.parquimetrov1.controller.resources.ParquimetroResources;
import com.example.parquimetrov1.domain.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parquimetro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean manutencao;
    private Status status;
    private String CEP;
    private String estado;
    private String cidade;


    public Parquimetro(ParquimetroResources resources) {
        this.id = resources.getId();
        this.manutencao = resources.isManutencao();
        this.status = resources.getStatus();
        this.CEP = resources.getCEP();
        this.estado = resources.getEstado();
        this.cidade = resources.getCidade();
    }
}
