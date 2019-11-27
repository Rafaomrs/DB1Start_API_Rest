package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Agencia;
import com.example.demo.domain.entity.Cidade;
import com.example.demo.repository.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public Agencia criar(String numero, String digito, String banco, Cidade cidade) {
		Agencia agencia = new Agencia(numero, digito, banco, cidade);
		return agenciaRepository.save(agencia);
	}
	public void deletarAgenciaPorId(Long id) {
		agenciaRepository.deleteById(id);
	}
	public Agencia buscarPorNumero(String numero) {
		return agenciaRepository.findByNumero(numero).orElseThrow(() -> new RuntimeException("Estado nao encontrado"));
	}
	public void clear() {
		agenciaRepository.deleteAll();
	}
}
