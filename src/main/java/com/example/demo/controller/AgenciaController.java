package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.AgenciaDto;
import com.example.demo.Dto.AgenciaFormDto;
import com.example.demo.Dto.CidadeFormDto;
import com.example.demo.adapter.AgenciaAdapter;
import com.example.demo.domain.entity.Agencia;
import com.example.demo.service.AgenciaService;

@RestController
public class AgenciaController {
	
	@Autowired
	private AgenciaService agenciaService;
	
	@GetMapping("/agencia")
	public List<AgenciaDto> buscarTodasAgencias(){
		List<Agencia> entidadeAgencia = agenciaService.buscarTodasAgencia();
		return entidadeAgencia.stream()
				.map(AgenciaAdapter::convertendoEntidadeParaDto).collect(Collectors.toList());
	}
	@PostMapping("/agencia")
	public AgenciaDto criarAgencia(@RequestBody AgenciaFormDto form, CidadeFormDto cidade) {
		Agencia agencia = agenciaService.criar(form, cidade);
		return AgenciaAdapter.convertendoEntidadeParaDto(agencia);
	}
	
}
