package com.example.demo.service;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.entity.Cidade;
import com.example.demo.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeServiceTeste {
	
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private EstadoService estadoService;
	
	
	
	@Test
	public void criarCidade() {
		Estado uf = estadoService.criar("Paraná");
		Cidade cidade = cidadeService.criar("Maringá", uf);
		assertNotNull(cidade);
		cidadeService.clear();
	}
	
	@Test
	public void deveDeletarCidadePorNome() {
		Estado uf = estadoService.criar("Paraná");
		Cidade cidade = cidadeService.criar("Maringá", uf);
		cidade = cidadeService.buscarPorNome("Maringá");
		
		try {
			cidadeService.buscarPorNome("Mandaguarí");
		}
		catch(RuntimeException test){
			System.out.println(test.getMessage());
		}
		cidadeService.clear();
	}
}
