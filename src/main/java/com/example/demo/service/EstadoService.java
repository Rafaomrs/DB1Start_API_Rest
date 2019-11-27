package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Estado;
import com.example.demo.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public Estado criar(String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
	}
	
	
	public void limpar() {
		estadoRepository.deleteAll();
	}
	
	public void deletarEstadoPorId(Long id) {
		estadoRepository.deleteById(id);
	}
	public Estado buscarPorNome(String nome) {
		return estadoRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Estado nao encontrado"));
	}
}
