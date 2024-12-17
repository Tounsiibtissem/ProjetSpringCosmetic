package com.exemple.jpaapp1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.jpaapp1.model.Produit;
import com.exemple.jpaapp1.repository.ProduitRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Iterable<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findAllById(id).orElse(null);
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Long id, Produit produitDetails) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit != null) {
            produit.setNom_produit(produitDetails.getNom_produit());
            produit.setDescription(produitDetails.getDescription());
            produit.setPrix(produitDetails.getPrix());
            produit.setStock(produitDetails.getStock());
            produit.setImage(produitDetails.getImage());
            return produitRepository.save(produit);
        }
        return null;
    }
    @Transactional
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
 
}
