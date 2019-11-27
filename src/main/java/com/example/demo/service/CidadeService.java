package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Cidade;
import com.example.demo.domain.entity.Estado;
import com.example.demo.repository.CidadeRepository;
import com.example.demo.repository.EstadoRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade criar(String nome, Estado uf) {
		estadoRepository.save(uf);
		Cidade cidade = new Cidade(nome, uf);
		return cidadeRepository.save(cidade);
	}
	public void deletarCidadePorId(Long id) {
		cidadeRepository.deleteById(id);
	}
	public Cidade buscarPorNome(String nome) {
		return cidadeRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Estado nao encontrado"));
	}
	public void clear() {
		cidadeRepository.deleteAll();
	}
	public void apagarCidadePorId(String nome) {
		
	}
}
