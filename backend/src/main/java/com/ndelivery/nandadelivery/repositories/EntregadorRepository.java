package com.ndelivery.nandadelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ndelivery.nandadelivery.entities.Entregador;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

}
