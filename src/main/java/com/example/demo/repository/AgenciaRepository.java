package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entity.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
	Optional<Agencia> findByNumero(String numero);
}

