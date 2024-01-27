package com.example.parquimetrov1.repository;

import com.example.parquimetrov1.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICarroRepository extends JpaRepository<Carro, Long> {

}

