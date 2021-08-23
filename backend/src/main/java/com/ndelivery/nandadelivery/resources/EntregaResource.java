package com.ndelivery.nandadelivery.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ndelivery.nandadelivery.dto.EntregaDTO;
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
}
