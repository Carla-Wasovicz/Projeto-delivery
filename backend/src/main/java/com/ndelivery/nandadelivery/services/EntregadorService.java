package com.ndelivery.nandadelivery.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ndelivery.nandadelivery.dto.EntregadorDTO;
import com.ndelivery.nandadelivery.entities.Entregador;
import com.ndelivery.nandadelivery.repositories.EntregadorRepository;

@Service
public class EntregadorService {
private EntregadorRepository repository;
	
	@Transactional(readOnly = true)
	public List<EntregadorDTO> findAll(){
		List<Entregador> lista = repository.findAll();
		return lista.stream().map(x -> new EntregadorDTO(x)).collect(Collectors.toList());

	}
	@Transactional(readOnly = true)
	public EntregadorDTO findById(Long id) {
		Optional<Entregador> obj = repository.findById(id);
		Entregador entregador = obj.get();
		return new EntregadorDTO(entregador);
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
		
			Entregador entity = repository.getById(id);
			entity.setCpf(dto.getCpf());
			entity.setNome(dto.getNome());
			entity.setTelefone(dto.getTelefone());
			entity = repository.save(entity);
			return new EntregadorDTO(entity);
		}
	public void delete(Long id) {
			repository.deleteById(id);
		
		
	}
	
	
}
