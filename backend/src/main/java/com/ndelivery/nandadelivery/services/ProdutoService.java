package com.ndelivery.nandadelivery.services;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		Produto produto = obj.get();
		return new ProdutoDTO(produto);
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
			Produto entity = repository.getById(id);
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
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possivel deletar, o id do produto não foi localizado");

		}
		
	}
	}
	

