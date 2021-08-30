package com.ndelivery.nandadelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndelivery.nandadelivery.dto.EntregaDTO;
import com.ndelivery.nandadelivery.dto.ProdutoDTO;
import com.ndelivery.nandadelivery.entities.Entrega;
import com.ndelivery.nandadelivery.entities.Produto;
import com.ndelivery.nandadelivery.repositories.EntregaRepository;
import com.ndelivery.nandadelivery.services.exeptions.ResourceNotFoundException;

@Service
public class EntregaService {
	@Autowired
	private EntregaRepository repository;
	
	@Transactional(readOnly = true)
	public List<EntregaDTO> findAll(){
		List<Entrega> lista = repository.findAll();
		return lista.stream().map(x -> new EntregaDTO(x)).collect(Collectors.toList());

	}
	@Transactional
	public EntregaDTO insert(EntregaDTO dto) {
		Entrega entity = new Entrega();
		entity.setPrecoEntrega(dto.getPrecoEntrega());
		entity = repository.save(entity);
		return new EntregaDTO(entity);
	}
	@Transactional
	public EntregaDTO update(Long id, EntregaDTO dto) {
		try {
			Entrega entity = repository.getOne(id);
			entity.setPrecoEntrega(dto.getPrecoEntrega());
			entity = repository.save(entity);
			return new EntregaDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id da entrega não foi localizado");
		}
		}
	}

