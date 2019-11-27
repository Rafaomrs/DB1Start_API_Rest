package com.example.demo.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.entity.Agencia;
import com.example.demo.domain.entity.Cidade;
import com.example.demo.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenciaServiceTest {
	
	@Autowired
	private AgenciaService agenciaService;
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private EstadoService estadoService;
	
	
	
	@Test
	public void criarAgencia() {
		Estado estado = estadoService.criar("Paraná");
		Cidade cidade = cidadeService.criar("Maringá", estado);
		Agencia agencia = agenciaService.criar("123", "2", "Banco do Brasil", cidade);
		assertNotNull(agencia);
		agenciaService.clear();
	}
	@Test
	public void deveBuscarAgenciaPorNumero() {
		Estado estado = estadoService.criar("Paraná");
		Cidade cidade = cidadeService.criar("Maringá", estado);
		Agencia agencia = agenciaService.criar("123", "2", "Banco do Brasil", cidade);
		agencia = agenciaService.buscarPorNumero("123");
		try {
			agenciaService.buscarPorNumero("222");
		}
		catch(RuntimeException test) {
			System.out.println(test.getMessage());
		}
		agenciaService.clear();
	}
}
