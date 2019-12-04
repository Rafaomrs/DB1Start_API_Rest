package com.example.demo.Dto;

public class AgenciaFormDto {
	
	
	private Long id;
	private String numeroAgencia;
	private String banco;
	private CidadeDto cidade;
	
	
	public Long getId() {
		return id;
	}
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public String getBanco() {
		return banco;
	}
	public CidadeDto getCidade() {
		return cidade;
	}

}
