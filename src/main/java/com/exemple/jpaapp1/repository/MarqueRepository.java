package com.exemple.jpaapp1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exemple.jpaapp1.model.Marque;

public interface MarqueRepository extends CrudRepository<Marque,Integer>{

	void deleteById(Long id);

	Optional<Marque> findById(Long id);

	Optional<Marque> findAllById(Long id);

}
