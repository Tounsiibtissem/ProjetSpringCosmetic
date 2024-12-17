package com.exemple.jpaapp1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.jpaapp1.model.Panier;
import com.exemple.jpaapp1.repository.PanierRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class PanierService {

    @Autowired
    private PanierRepository panierRepository;

    public Iterable<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    public Panier getPanierById(Long id) {
        return panierRepository.findById(id).orElse(null);
    }

    public Panier createPanier(Panier panier) {
        return panierRepository.save(panier);
    }

    public Panier updatePanier(Long id, Panier panierDetails) {
        Panier panier = panierRepository.findById(id).orElse(null);
        if (panier != null) {
            return panierRepository.save(panier);
        }
        return null;
    }
    @Transactional
    public void deletePanier(Long id) {
        panierRepository.deleteById(id);
    }
}

