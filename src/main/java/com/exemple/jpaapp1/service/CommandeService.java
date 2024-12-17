package com.exemple.jpaapp1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.jpaapp1.model.Commande;
import com.exemple.jpaapp1.repository.CommandeRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Iterable<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande updateCommande(Long id, Commande commandeDetails) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        if (commande != null) {
            commande.setTotalProduit(commandeDetails.getTotal());
            return commandeRepository.save(commande);
        }
        return null;
    }
    @Transactional
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
