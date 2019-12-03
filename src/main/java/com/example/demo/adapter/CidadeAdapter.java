package com.example.demo.adapter;

import com.example.demo.Dto.CidadeDto;
import com.example.demo.domain.entity.Cidade;

public class CidadeAdapter {
	
	public static CidadeDto transformarEntidadeParaDto(Cidade cidade) {
		CidadeDto dto = new CidadeDto();
		dto.setId(cidade.getId());
		dto.setNome(cidade.getNome());
		return dto;
	}
}
