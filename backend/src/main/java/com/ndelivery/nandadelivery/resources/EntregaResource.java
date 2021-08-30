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

import com.ndelivery.nandadelivery.dto.EntregaDTO;
import com.ndelivery.nandadelivery.dto.ProdutoDTO;
import com.ndelivery.nandadelivery.services.EntregaService;

@RestController
@RequestMapping(value = "/estregas" )
public class EntregaResource {
	
	@Autowired
	private EntregaService service;
	
	@GetMapping
	public ResponseEntity<List<EntregaDTO>> findAll(){	
		List<EntregaDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	@PostMapping  
	public ResponseEntity<EntregaDTO> insert(@RequestBody EntregaDTO dto){	
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "{/id}")
	public ResponseEntity<EntregaDTO>update(@PathVariable Long id,@RequestBody EntregaDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
