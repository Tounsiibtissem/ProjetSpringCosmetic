package com.exemple.jpaapp1.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.exemple.jpaapp1.model.Produit;



public interface ProduitRepository extends CrudRepository<Produit,Integer>{

	static Optional<Produit> getProduitById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	static List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	static Produit saveProduit(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}

	static void deleteProduit(int id) {
		// TODO Auto-generated method stub
		
	}

	static Produit updateProduit(int id, Produit produitDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	Optional<Produit> findAllById(Long id);

	Optional<Produit> findById(Long id);

	void deleteById(Long id);
	
	@Query("SELECT p FROM Produit p WHERE p.categorie.id = :categorieId")
    List<Produit> findByCategorieID(@Param("categorieId") Long categorieId);
	
	// Recherche des produits par nom de catégorie
    @Query("SELECT p FROM Produit p WHERE p.categorie.nom_categorie = :categorieNom")
    List<Produit> findByCategorieNom(@Param("categorieNom") String categorieNom);

	

}
