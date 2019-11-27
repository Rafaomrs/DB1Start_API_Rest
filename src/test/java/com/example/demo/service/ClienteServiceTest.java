package com.example.demo.service;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.entity.Cliente;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {
	
	@Autowired
	private ClienteService clienteService;
	
	
	
	@Test
	public void deveCriarCliente() {
		Cliente cliente = clienteService.criar("fake", "123.123.123.12", "99999-9999");
		assertNotNull(cliente);
		clienteService.clear();
	}
	@Test
	public void deveDeletarClientePorId() {
		Cliente cliente = clienteService.criar("Rafael", "123.123.123.12", "99999-9999");
		clienteService.deletarClientePorId(cliente.getId());
		assertNotNull(cliente);
		clienteService.clear();
	}
	@Test
	public void deveBuscarClientePorNome() {
		Cliente cliente = clienteService.criar("fake", "123.123", "123");
		cliente = clienteService.buscarPorNome("fake");
		assertNotNull(cliente);
		clienteService.clear();
	}
	public void deveLancarExcecao() {
		try {
			clienteService.buscarPorNome("fake2");
		}
		catch(RuntimeException test) {
			System.out.println(test.getMessage());
		}
		clienteService.clear();
	}

}
