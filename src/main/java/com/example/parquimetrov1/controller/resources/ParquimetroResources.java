package com.example.parquimetrov1.controller.resources;

import com.example.parquimetrov1.domain.Parquimetro;
import com.example.parquimetrov1.domain.enums.Status;
import lombok.Data;

import java.util.Optional;

@Data
public class ParquimetroResources {

    private Long id;
    private boolean manutencao;
    private Status status;
    private String CEP;
    private String estado;
    private String cidade;


    public ParquimetroResources() {

    }

    public ParquimetroResources(Parquimetro parquimetro) {
        this.id = parquimetro.getId();
        this.manutencao = parquimetro.isManutencao();
        this.status = parquimetro.getStatus();
        this.CEP = parquimetro.getCEP();
        this.estado = parquimetro.getEstado();
        this.cidade = parquimetro.getCidade();
    }

    public ParquimetroResources(Optional<Parquimetro> parquimetro) {
        this.id = parquimetro.get().getId();
        this.manutencao = parquimetro.get().isManutencao();
        this.status = parquimetro.get().getStatus();
        this.CEP = parquimetro.get().getCEP();
        this.estado = parquimetro.get().getEstado();
        this.cidade = parquimetro.get().getCidade();
    }
}
