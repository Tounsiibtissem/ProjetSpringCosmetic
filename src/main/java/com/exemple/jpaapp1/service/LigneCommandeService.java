package com.exemple.jpaapp1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.jpaapp1.model.LigneCommande;
import com.exemple.jpaapp1.repository.LigneCommandeRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public Iterable<LigneCommande> getAllLignesCommande() {
        return ligneCommandeRepository.findAll();
    }

    public LigneCommande getLigneCommandeById(Long id) {
        return ligneCommandeRepository.findById(id).orElse(null);
    }

    public LigneCommande createLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    public LigneCommande updateLigneCommande(Long id, LigneCommande ligneCommandeDetails) {
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id).orElse(null);
        if (ligneCommande != null) {
            ligneCommande.setQuantite(ligneCommandeDetails.getQuantite());
            ligneCommande.setCommande(ligneCommandeDetails.getCommande());
            ligneCommande.setProduit(ligneCommandeDetails.getProduit());
            ligneCommande.setPanier(ligneCommandeDetails.getPanier());
            return ligneCommandeRepository.save(ligneCommande);
        }
        return null;
    }
    @Transactional
    public void deleteLigneCommande(Long id) {
        ligneCommandeRepository.deleteById(id);
    }
}
