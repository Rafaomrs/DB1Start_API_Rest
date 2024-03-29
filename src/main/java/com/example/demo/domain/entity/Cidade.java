package com.example.demo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", length = 60)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado uf;
	
	public Cidade() {
		
	}
	
	public Cidade(String nome, Estado uf){
		this.nome = nome;
		this.uf = uf;
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Estado getUf() {
		return uf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
