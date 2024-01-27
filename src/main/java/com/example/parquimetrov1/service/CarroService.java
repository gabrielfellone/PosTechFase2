package com.example.parquimetrov1.service;

import com.example.parquimetrov1.controller.resources.CarroResources;
import com.example.parquimetrov1.controller.resources.ParquimetroResources;
import com.example.parquimetrov1.domain.Carro;
import com.example.parquimetrov1.domain.Credito;
import com.example.parquimetrov1.domain.Parquimetro;
import com.example.parquimetrov1.domain.enums.Status;
import com.example.parquimetrov1.exception.ParquimetroException;
import com.example.parquimetrov1.repository.ICarroRepository;
import com.example.parquimetrov1.repository.ICarroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarroService implements ICarroService {

    @Autowired
    private ICarroRepository carroRepository;

    private final CreditoService creditoService;
    private final ParquimetroService parquimetroService;

    @Override
    public List<Carro> getListaCarros() {
        return carroRepository.findAll();
    }

    public Carro solicitaParquimetro(CarroResources request) {

        log.info("Solicitando parquimetro para o carro {}", request.getId());

        Credito credito = creditoService.getCreditoById(request.getId_credito());

        ParquimetroResources parquimetroResources =
                parquimetroService.getParquimetro(request.getId_parquimetro());

        if (Objects.nonNull(credito)
                && validaParquimetro(parquimetroResources, request)) {

            log.info("Salvando na base data de inicio do parquimetro do carro {}", request.getPlaca());

            Carro carro = new Carro(request);
            carro.setDtaInicio(carro.getDtaInicio().plusDays(2));
            Parquimetro parquimetro = new Parquimetro(parquimetroResources);

            log.info("Atualizando informações na base");

            salvaCarro(carro);
            parquimetroService.salvaParquimetro(parquimetro);

            return carro;


        } else {
            throw new ParquimetroException("Não foi possivel solicitar parquimetro ");
        }
    }

    public Carro getCarroById(Long id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return new Carro(carro);

    }

    public void salvaCarro(Carro carro) {
        carroRepository.save(carro);
    }

    public boolean validaParquimetro(ParquimetroResources parquimetro,
                                     CarroResources request) {
        if (Status.INDISPONIVEL.equals(parquimetro.getStatus())) {
            return false;
        }
        if (parquimetro.isManutencao()) {
            return false;
        }

        Carro carro = getCarroById(request.getId());

        if (carro.getDtaInicio().isBefore(request.getDtaInicio())) {
            log.info("Data dentro do prazo para renovar");
            return true;
        } else {
            return false;
        }
    }
}
