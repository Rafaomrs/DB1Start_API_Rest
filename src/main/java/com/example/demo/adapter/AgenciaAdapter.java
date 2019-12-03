package com.example.demo.adapter;

import com.example.demo.Dto.AgenciaDto;
import com.example.demo.Dto.CidadeDto;
import com.example.demo.domain.entity.Agencia;

public class AgenciaAdapter {
	
	public static AgenciaDto convertendoEntidadeParaDto(Agencia agencia) {
		AgenciaDto dto = new AgenciaDto();
		CidadeDto cidade = new CidadeDto();
		cidade.setNome(agencia.getCidade().getNome());
		dto.setId(agencia.getId());
		dto.setNumeroAgencia(agencia.getNumero());
		dto.setCidade(cidade);
		dto.setBanco(agencia.getBanco());
		return dto;
	}
}
