package com.exemple.jpaapp1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exemple.jpaapp1.model.Panier;



public interface PanierRepository extends CrudRepository<Panier,Integer>{

	Optional<Panier> findById(Long id);

	void deleteById(Long id);

}
