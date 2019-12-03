package com.example.demo.Dto;

public class AgenciaDto {
	
	private Long id;
	private String numeroAgencia;
	private String banco;
	private CidadeDto cidade;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public CidadeDto getCidade() {
		return cidade;
	}
	public void setCidade(CidadeDto cidade) {
		this.cidade = cidade;
	}

}
