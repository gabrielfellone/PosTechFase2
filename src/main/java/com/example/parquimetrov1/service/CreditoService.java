package com.example.parquimetrov1.service;

import com.example.parquimetrov1.domain.Carro;
import com.example.parquimetrov1.domain.Credito;
import com.example.parquimetrov1.repository.ICreditoRepository;
import com.example.parquimetrov1.repository.ICreditoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditoService implements ICreditoService {

    @Autowired
    private ICreditoRepository creditoRepository;

    @Override
    public List<Credito> getListaCreditos() {
        return creditoRepository.findAll();
    }

    public Credito getCreditoById(Long id){
        Optional<Credito> credito = creditoRepository.findById(id);
        return new Credito(credito);

    }
    public void salvaCredito(Credito credito) {
        creditoRepository.save(credito);
    }


}
