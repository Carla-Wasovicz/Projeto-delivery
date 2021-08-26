package com.ndelivery.nandadelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndelivery.nandadelivery.dto.PedidoDTO;
import com.ndelivery.nandadelivery.dto.ProdutoDTO;
import com.ndelivery.nandadelivery.entities.Pedido;
import com.ndelivery.nandadelivery.entities.Produto;
import com.ndelivery.nandadelivery.entities.StatusPedido;
import com.ndelivery.nandadelivery.repositories.PedidoRepository;
import com.ndelivery.nandadelivery.repositories.ProdutoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional(readOnly = true)
	public List<PedidoDTO> findAll(){
		List<Pedido> lista = repository.findPedidosWithProdutos();
		return lista.stream().map(x -> new PedidoDTO(x)).collect(Collectors.toList());
		
	}
	@Transactional
	public PedidoDTO insert(PedidoDTO dto){
		Pedido pedido = new Pedido(null, dto.getEndereco(), dto.getLatitude(), dto.getLongitude(),
				Instant.now(),StatusPedido.PENDENTE);
		for (ProdutoDTO p : dto.getProdutos()) {
			Produto produto = produtoRepository.getOne(p.getId());
			pedido.getProdutos().add(produto);
		}
		pedido = repository.save(pedido);
		return new PedidoDTO(pedido);
	}
	@Transactional
	public PedidoDTO setEntregue(Long id){
		Pedido pedido = repository.getOne(id);
		pedido.setStatus(StatusPedido.ENTREGUE);
		pedido = repository.save(pedido);
		return new PedidoDTO(pedido);
	}
}
