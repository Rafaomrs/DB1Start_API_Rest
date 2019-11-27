package com.example.demo.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "agencia")
public class Agencia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name  = "numero", length = 30)
	private String numero;
	
	@Column(name  = "digito", length = 10)
	private String digito;
	@Column(name  = "banco", length = 30)
	private String banco;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	@OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Conta> conta;
	
	public Agencia() {
		this.conta = new ArrayList<>();
		
	}
	
	public Agencia(String numero, String digito, String banco, Cidade cidade) {
		this.numero = numero;
		this.digito = digito;
		this.banco = banco;
		this.cidade = cidade;
		this.conta = new ArrayList<>();
	}
	
	public long getId() {
		return id;
	}
	public String getNumero() {
		return numero;
	}
	public String getDigito() {
		return digito;
	}
	public String getBanco() {
		return banco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public List<Conta> getConta(){
		return conta;
	}
	
}
