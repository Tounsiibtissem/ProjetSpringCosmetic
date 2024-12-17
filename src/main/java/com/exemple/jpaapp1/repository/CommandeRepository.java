package com.exemple.jpaapp1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exemple.jpaapp1.model.Commande;



public interface CommandeRepository extends CrudRepository<Commande,Integer>{

	Optional<Commande> findById(Long id);

	void deleteById(Long id);

}
