package com.example.demo.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.CidadeDto;
import com.example.demo.Dto.CidadeFormDto;
import com.example.demo.adapter.CidadeAdapter;
import com.example.demo.domain.entity.Cidade;
import com.example.demo.service.CidadeService;

@RestController
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/Cidades")
    public List<CidadeDto> buscarTodoasCidades() {
        List<Cidade> entidadesCidade = cidadeService.buscarTodasCidades();
        return entidadesCidade.stream()
                .map(CidadeAdapter::transformarEntidadeParaDto).collect(Collectors.toList());
    }
	
	@PostMapping("/Cidades")
	public CidadeDto criarCidade(@RequestBody CidadeFormDto cidadeFormDto) {
		Cidade cidade = cidadeService.criar(cidadeFormDto);
		return CidadeAdapter.transformarEntidadeParaDto(cidade);
	}
}
