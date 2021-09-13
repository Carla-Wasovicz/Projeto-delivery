package com.ndelivery.nandadelivery.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.ndelivery.nandadelivery.dto.EntregadorDTO;
import com.ndelivery.nandadelivery.services.EntregadorService;

@RestController
@RequestMapping(value = "/entregadores" )
public class EntregadorResource {
	@Autowired
	private EntregadorService service;
	
	@GetMapping
	public ResponseEntity<List<EntregadorDTO>> findAll(){	
		List<EntregadorDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	@PostMapping  
	public ResponseEntity<EntregadorDTO>insert(@RequestBody EntregadorDTO dto){	
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "{/id}")
	public ResponseEntity<EntregadorDTO>update(@PathVariable Long id,@RequestBody EntregadorDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	@DeleteMapping(value = "{/id}")
	public ResponseEntity<EntregadorDTO>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
