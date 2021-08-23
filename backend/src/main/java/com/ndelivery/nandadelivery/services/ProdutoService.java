package com.ndelivery.nandadelivery.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndelivery.nandadelivery.dto.ProdutoDTO;
import com.ndelivery.nandadelivery.entities.Produto;
import com.ndelivery.nandadelivery.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProdutoDTO> findAll(){
		List<Produto> lista = repository.findAllByOrderByNomeAsc();
		return lista.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
		
	}
	
}
