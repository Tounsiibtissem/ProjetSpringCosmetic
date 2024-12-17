package com.exemple.jpaapp1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.jpaapp1.model.Categorie;
import com.exemple.jpaapp1.repository.CategorieRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Iterable<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(Long id, Categorie categorieDetails) {
        Categorie categorie = categorieRepository.findById(id).orElse(null);
        if (categorie != null) {
            categorie.setNom_categorie(categorieDetails.getNom_categorie());
            return categorieRepository.save(categorie);
        }
        return null;
    }
    @Transactional
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}

