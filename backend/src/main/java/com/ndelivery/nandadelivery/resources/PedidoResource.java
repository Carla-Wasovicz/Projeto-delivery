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
import com.ndelivery.nandadelivery.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos" )
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> findAll(){	
		List<PedidoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	@PostMapping
	public ResponseEntity<PedidoDTO> insert (@RequestBody PedidoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}/entregue")
	public ResponseEntity<PedidoDTO> setEntregue(@PathVariable Long id){
		PedidoDTO dto = service.setEntregue(id);
		return ResponseEntity.ok().body(dto);
		
	} 
}









