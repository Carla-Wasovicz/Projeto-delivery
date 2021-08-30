package com.ndelivery.nandadelivery.services;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndelivery.nandadelivery.dto.ProdutoDTO;
import com.ndelivery.nandadelivery.entities.Produto;
import com.ndelivery.nandadelivery.repositories.ProdutoRepository;
import com.ndelivery.nandadelivery.services.exeptions.ResourceNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProdutoDTO> findAll(){
		List<Produto> lista = repository.findAllByOrderByNomeAsc();
		return lista.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
		
	}
	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setDescricao(dto.getDescricao());
		entity.setNome(dto.getNome());
		entity.setPreco(dto.getPreco());
		entity.setImagem(dto.getImagem());
		entity = repository.save(entity);
		return new ProdutoDTO(entity);
	}
	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		try {
			Produto entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setNome(dto.getNome());
			entity.setPreco(dto.getPreco());
			entity.setImagem(dto.getImagem());
			entity = repository.save(entity);
			return new ProdutoDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id do produto não foi localizado");
		}
		}
	}
	

