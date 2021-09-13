package com.ndelivery.nandadelivery.services;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ndelivery.nandadelivery.dto.EntregadorDTO;
import com.ndelivery.nandadelivery.entities.Entregador;
import com.ndelivery.nandadelivery.repositories.EntregadorRepository;
import com.ndelivery.nandadelivery.services.exeptions.ResourceNotFoundException;

@Service
public class EntregadorService {
private EntregadorRepository repository;
	
	@Transactional(readOnly = true)
	public List<EntregadorDTO> findAll(){
		List<Entregador> lista = repository.findAll();
		return lista.stream().map(x -> new EntregadorDTO(x)).collect(Collectors.toList());

	}
	@Transactional
	public EntregadorDTO insert(EntregadorDTO dto) {
		Entregador entity = new Entregador();
		entity.setCpf(dto.getCpf());
		entity.setNome(dto.getNome());
		entity.setTelefone(dto.getTelefone());
		entity = repository.save(entity);
		return new EntregadorDTO(entity);
	}
	@Transactional
	public EntregadorDTO update(Long id, EntregadorDTO dto) {
		try {
			Entregador entity = repository.getById(id);
			entity.setCpf(dto.getCpf());
			entity.setNome(dto.getNome());
			entity.setTelefone(dto.getTelefone());
			entity = repository.save(entity);
			return new EntregadorDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id da entrega não foi localizado");
		}
		}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possivel deletar,o id da entrega não foi localizado");

		}
		
	}
	
}
