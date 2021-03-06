package com.ndelivery.nandadelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ndelivery.nandadelivery.entities.Pedido;
import com.ndelivery.nandadelivery.entities.StatusPedido;

public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String endereco;
	private Double latitude;
	private Double longitude;
	private Instant hora;
	private StatusPedido status;
	private Double total;
	
	private List<ProdutoDTO> produtos = new ArrayList<>();
	
	public PedidoDTO() {}


	public PedidoDTO(Long id, String endereco, Double latitude, Double longitude, Instant hora, StatusPedido status, Double total) {
		this.id = id;
		this.endereco = endereco;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hora = hora;
		this.status = status;
		this.total = total;
	}
	
	public PedidoDTO(Pedido entity) {
		id = entity.getId();
		endereco = entity.getEndereco() ;
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		hora = entity.getHora();
		status = entity.getStatus();
		total = entity.getTotal();
		produtos = entity.getProdutos().stream().
				map(x -> new ProdutoDTO()).collect(Collectors.toList());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public Instant getHora() {
		return hora;
	}


	public void setHora(Instant hora) {
		this.hora = hora;
	}


	public StatusPedido getStatus() {
		return status;
	}


	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public List<ProdutoDTO> getProdutos() {
		return produtos;
	}

}
