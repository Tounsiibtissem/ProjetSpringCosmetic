package com.exemple.jpaapp1.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exemple.jpaapp1.model.Categorie;



public interface CategorieRepository extends CrudRepository<Categorie,Integer>{

	Optional<Categorie> findById(Long id);

	void deleteById(Long id);

}
