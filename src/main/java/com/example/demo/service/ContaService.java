package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Agencia;
import com.example.demo.domain.entity.Cliente;
import com.example.demo.domain.entity.Conta;
import com.example.demo.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	public Conta criar(Agencia agencia, Double saldo, Cliente cliente) {
		Conta conta = new Conta(agencia, saldo, cliente);
		return contaRepository.save(conta);
	}
	public void deletarContaPorId(Long id) {
		contaRepository.deleteById(id);
	}
	
	public Conta buscarPorId(Long id) {
		return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado nao encontrado"));
	}
	public void clear() {
		contaRepository.deleteAll();
	}
}
