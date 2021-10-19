package com.ndelivery.nandadelivery.dto;

import java.io.Serializable;

import com.ndelivery.nandadelivery.entities.Entregador;

public class EntregadorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String cpf;
	private String nome;
	private String telefone;
	
	public EntregadorDTO() {}

	public EntregadorDTO(Long id, String cpf, String nome, String telefone) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}
	public EntregadorDTO(Entregador entity) {
		id = entity.getId();
		cpf = entity.getCpf();
		nome = entity.getNome();
		telefone = entity.getTelefone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
