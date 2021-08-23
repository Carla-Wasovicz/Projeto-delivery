package com.ndelivery.nandadelivery.dto;

import java.io.Serializable;

import com.ndelivery.nandadelivery.entities.Entrega;

public class EntregaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double precoEntrega;
	
	public EntregaDTO() {}

	public EntregaDTO(Long id, Double precoEntrega) {
		this.id = id;
		this.precoEntrega = precoEntrega;
	}
	public EntregaDTO(Entrega entity) {
	    id = entity.getId();
		precoEntrega = entity.getPrecoEntrega();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrecoEntrega() {
		return precoEntrega;
	}

	public void setPrecoEntrega(Double precoEntrega) {
		this.precoEntrega = precoEntrega;
	}
	
	
}
