package com.exemple.jpaapp1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exemple.jpaapp1.model.LigneCommande;
import com.exemple.jpaapp1.model.Panier;
import com.exemple.jpaapp1.model.Produit;



public interface LigneCommandeRepository extends CrudRepository<LigneCommande,Integer>{

	Optional<LigneCommande> findById(Long id);

	void deleteById(Long id);
	LigneCommande findByPanierAndProduit(Panier panier, Produit produit);
    List<LigneCommande> findByPanier(Panier panier);

}
