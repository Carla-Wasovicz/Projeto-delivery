package com.ndelivery.nandadelivery.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}