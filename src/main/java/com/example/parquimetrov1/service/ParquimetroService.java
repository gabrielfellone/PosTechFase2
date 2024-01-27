package com.example.parquimetrov1.service;

import com.example.parquimetrov1.controller.resources.ParquimetroResources;
import com.example.parquimetrov1.domain.Parquimetro;
import com.example.parquimetrov1.repository.IParquimetroRepository;
import com.example.parquimetrov1.repository.IParquimetroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParquimetroService implements IParquimetroService {

    @Autowired
    private IParquimetroRepository parquimetroRepository;

    @Override
    public List<ParquimetroResources> getListaParquimetros() {
        return parquimetroRepository.findAll().stream().map(ParquimetroResources::new).toList();
    }
    public void salvaParquimetro(Parquimetro resource){
        parquimetroRepository.save(resource);
    }

    public ParquimetroResources getParquimetro(Long id){
        Optional<Parquimetro> parquimetro = parquimetroRepository.findById(id);
        return new ParquimetroResources(parquimetro);

    }


}
