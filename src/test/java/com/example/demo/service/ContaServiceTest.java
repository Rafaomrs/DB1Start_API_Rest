package com.example.demo.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.entity.Agencia;
import com.example.demo.domain.entity.Cidade;
import com.example.demo.domain.entity.Cliente;
import com.example.demo.domain.entity.Conta;
import com.example.demo.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaServiceTest {
	
	@Autowired
	private ContaService contaService;
	
	@Autowired
	private AgenciaService agenciaService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private ClienteService clienteService;
	
	
	@Test
	public void criarConta() {
		Estado uf = estadoService.criar("Paraná");
		Cidade cidade = cidadeService.criar("Maringá", uf);
		Agencia agencia = agenciaService.criar("123", "2", "Banco do Brasil", cidade);
		Cliente cliente = clienteService.criar("fake", "123.123.123-1", "99999999");
		Conta conta = contaService.criar(agencia, 0.0, cliente);
		assertNotNull(conta);
		contaService.clear();
		
	}
	
	@Test
	public void deveBuscarContaPorId() {
		Estado uf = estadoService.criar("Paraná");
		Cidade cidade = cidadeService.criar("Maringá", uf);
		Agencia agencia = agenciaService.criar("123", "2", "Banco do Brasil", cidade);
		Cliente cliente = clienteService.criar("fake", "123.123.123-1", "99999999");
		Conta conta = contaService.criar(agencia, 0.0, cliente);
		conta = contaService.buscarPorId(conta.getId());
		assertNotNull(conta);
		contaService.clear();
	}
	
	@Test
	public void deveLancarExcecao() {
		try {
			Estado uf = estadoService.criar("Paraná");
			Cidade cidade = cidadeService.criar("Maringá", uf);
			Agencia agencia = agenciaService.criar("123", "2", "Banco do Brasil", cidade);
			Cliente cliente = clienteService.criar("fake", "123.123.123-1", "99999999");
			Conta conta = contaService.criar(agencia, 0.0, cliente);
			conta = contaService.buscarPorId(conta.getId());
		}
		catch(RuntimeException test) {
			System.out.println(test.getMessage());
		}
		contaService.clear();
	}
}
