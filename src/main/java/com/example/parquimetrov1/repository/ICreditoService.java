package com.example.parquimetrov1.repository;

import com.example.parquimetrov1.domain.Carro;
import com.example.parquimetrov1.domain.Credito;

import java.util.List;

public interface ICreditoService {
    List<Credito> getListaCreditos();
}
