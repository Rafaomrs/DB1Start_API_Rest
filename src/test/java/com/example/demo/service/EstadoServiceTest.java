package com.example.demo.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.entity.Estado;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoServiceTest {
	
	@Autowired
	private EstadoService estadoService;
	
//	@After
//	public void clean() {
//		estadoService.limpar();
//	}
	
	@Test
	public void test() {
		Estado estado = estadoService.criar("Paraná");
		
		assertNotNull(estado);
		System.out.println(estado.getId());
	}
	
	@Test
	public void trocarEstadoPorId() {
		Estado estado = estadoService.criar("Mato Grosso");
		estadoService.deletarEstadoPorId(estado.getId());
		assertNotNull(estado);
	}
	@Test
	public void deveBuscarEstado() {
		Estado estado = estadoService.buscarPorNome("Paraná");
		assertNotNull(estado);
	}
	@Test
	public void deveLancarExcecao() {
		
		try {
			Estado estado = estadoService.buscarPorNome("São Paulo");
		}
		catch(RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
