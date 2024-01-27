package com.example.parquimetrov1.domain;

import com.example.parquimetrov1.domain.enums.Metodo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.UUID;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credito {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Metodo metodo;
    private String placaCarro;
    private float valor;

    public Credito(Optional<Credito> credito) {
        this.metodo = credito.get().getMetodo();
        this.placaCarro = credito.get().getPlacaCarro();
        this.valor = credito.get().getValor();
    }
}
