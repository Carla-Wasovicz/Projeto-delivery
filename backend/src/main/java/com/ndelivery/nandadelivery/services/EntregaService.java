package com.ndelivery.nandadelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndelivery.nandadelivery.dto.EntregaDTO;
import com.ndelivery.nandadelivery.entities.Entrega;
import com.ndelivery.nandadelivery.repositories.EntregaRepository;

@Service
public class EntregaService {
	@Autowired
	private EntregaRepository repository;
	
	@Transactional(readOnly = true)
	public List<EntregaDTO> findAll(){
		List<Entrega> lista = repository.findAll();
		return lista.stream().map(x -> new EntregaDTO(x)).collect(Collectors.toList());

	}
}
