package com.ndelivery.nandadelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ndelivery.nandadelivery.entities.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{
	
}
