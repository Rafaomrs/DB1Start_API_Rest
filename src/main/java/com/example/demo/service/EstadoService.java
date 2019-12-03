package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.EstadoFormDto;
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
	
	public List<Estado> BuscarTodos() {
		return estadoRepository.findAll();
	}
	public Estado buscarPorId(long id) {
		return estadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado nao encontrado"));
	}
    public Estado atualizar(Long estadoId, String novoNome) {
        Estado estado = buscarPorId(estadoId);
        estado.setNome(novoNome);
        return estadoRepository.save(estado);
    }
    public Estado atualizar(Long estadoId, EstadoFormDto alteracoes) {
        Estado estado = buscarPorId(estadoId);
        estado.setNome(alteracoes.getNome());
        return estadoRepository.save(estado);
    }
}
