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
	@PutMapping("/Cidades/{cidadeId}")
	public void atualizarCidade(@PathVariable Long cidadeId, @RequestBody CidadeFormDto form) {
		cidadeService.atualizar(cidadeId, form);
	}
	@DeleteMapping("/Cidades/{cidadeId}")
	public void deletarCidade(@PathVariable Long cidadeId) {
		cidadeService.deletarCidadePorId(cidadeId);
	}
}
