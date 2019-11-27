package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	Optional<Estado> findByNome(String nome);
}
