package com.example.demo.adapter;

import com.example.demo.Dto.EstadoDto;
import com.example.demo.Dto.EstadoFormDto;
import com.example.demo.domain.entity.Estado;

public class EstadoAdapter {

	
    public static EstadoDto converteEntidadeEstadoParaDTO(Estado estado) {
    	EstadoDto estadoDTO = new EstadoDto();
        estadoDTO.setId(estado.getId());
        estadoDTO.setNome(estado.getNome());
        return estadoDTO;
    }

    public static Estado converteDTOParaEntidadeEstado(EstadoFormDto dto) {
        Estado estado = new Estado();
        estado.setNome(dto.getNome());
        return estado;
    }
}
