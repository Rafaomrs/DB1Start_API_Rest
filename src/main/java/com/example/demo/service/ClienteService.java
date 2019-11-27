package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente criar(String nome, String cpf, String telefone) {
		Cliente cliente = new Cliente(nome, cpf, telefone);
		return clienteRepository.save(cliente);
	}
	public void deletarClientePorId(Long id) {
		clienteRepository.deleteById(id);
	}
	public void deletarClientePorNome(String nome) {
		clienteRepository.deleteAllInBatch();
	}
	public Cliente buscarPorNome(String nome) {
		return clienteRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Estado nao encontrado"));
	}
	public void clear() {
		clienteRepository.deleteAll();
	}
}
