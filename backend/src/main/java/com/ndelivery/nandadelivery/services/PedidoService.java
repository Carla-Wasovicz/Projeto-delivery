package com.ndelivery.nandadelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndelivery.nandadelivery.dto.PedidoDTO;
import com.ndelivery.nandadelivery.entities.Pedido;
import com.ndelivery.nandadelivery.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repository;
	
	@Transactional(readOnly = true)
	public List<PedidoDTO> findAll(){
		List<Pedido> lista = repository.findAll();
		return lista.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
		
	}
}
