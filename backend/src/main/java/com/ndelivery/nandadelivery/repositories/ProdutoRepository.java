package com.ndelivery.nandadelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ndelivery.nandadelivery.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findAllByOrderByNomeAsc();
}
