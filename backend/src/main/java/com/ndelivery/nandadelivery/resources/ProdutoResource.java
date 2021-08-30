package com.ndelivery.nandadelivery.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ndelivery.nandadelivery.dto.PedidoDTO;
import com.ndelivery.nandadelivery.dto.ProdutoDTO;
import com.ndelivery.nandadelivery.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos" )
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll(){	
		List<ProdutoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	@PostMapping  
	public ResponseEntity<ProdutoDTO>insert(@RequestBody ProdutoDTO dto){	
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "{/id}")
	public ResponseEntity<ProdutoDTO>update(@PathVariable Long id,@RequestBody ProdutoDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
