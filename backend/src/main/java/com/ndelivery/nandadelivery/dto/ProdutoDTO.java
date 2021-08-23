package com.ndelivery.nandadelivery.dto;

import java.io.Serializable;

import com.ndelivery.nandadelivery.entities.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Double preco;
	private String descricao;
	private String imagem;
	
	public ProdutoDTO() {}

	public ProdutoDTO(Long id, String nome, Double preco, String descricao, String imagem) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.imagem = imagem;
	}
	
	public ProdutoDTO(Produto entity) {
		id = entity.getId();
		nome = entity.getNome();
		preco = entity.getPreco();
		descricao = entity.getDescricao();
		imagem = entity.getImagem();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}	
}
