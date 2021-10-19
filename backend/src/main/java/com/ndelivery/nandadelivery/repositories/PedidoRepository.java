package com.ndelivery.nandadelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ndelivery.nandadelivery.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	@Query("SELECT DISTINCT obj FROM Pedido obj JOIN FETCH obj.produtos"
			+ " WHERE obj.status = 0 ORDER BY obj.hora ASC")
	List<Pedido> findPedidosWithProdutos();
	
}
