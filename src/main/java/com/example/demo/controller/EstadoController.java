package com.example.demo.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.EstadoDto;
import com.example.demo.Dto.EstadoFormDto;
import com.example.demo.adapter.EstadoAdapter;
import com.example.demo.domain.entity.Estado;
import com.example.demo.service.EstadoService;

@RestController
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	//EndPoint
	@GetMapping("/Estados")      
    public List<EstadoDto> buscarTodosEstados() {
        List<Estado> entidadesEstado = estadoService.BuscarTodos();
        return entidadesEstado.stream()
                .map(EstadoAdapter::converteEntidadeEstadoParaDTO).collect(Collectors.toList());
    }
	@PostMapping("/Estados")
	public EstadoDto cadastrarNovoEstado(@RequestBody EstadoFormDto form) {
		Estado estado = estadoService.criar(form.getNome());
		return EstadoAdapter.converteEntidadeEstadoParaDTO(estado);
	}
	
	@PutMapping("/Estado/{estadoId}")
	public void atualizaEstado(@PathVariable Long estadoId, @RequestBody EstadoFormDto form) {
		estadoService.atualizar(estadoId, form);
	}
	@DeleteMapping("/Estado/{estadoId}")
	public void deletaEstado(@PathVariable Long estadoId) {
		estadoService.deletarEstadoPorId(estadoId);
	}
}
