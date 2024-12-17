package com.exemple.jpaapp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.jpaapp1.service.PaiementService;
import com.exemple.jpaapp1.model.paiement;
@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    /**
     * Récupérer tous les paiements.
     */
    @GetMapping
    public List<paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    /**
     * Récupérer un paiement par ID.
     */
    @GetMapping("/{id}")
    public paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id);
    }

    /**
     * Créer un nouveau paiement.
     */
    @PostMapping
    public paiement createPaiement(@RequestBody paiement paiement) {
        return paiementService.createPaiement(paiement);
    }

    /**
     * Mettre à jour un paiement existant.
     */
    @PutMapping("/{id}")
    public paiement updatePaiement(@PathVariable Long id, @RequestBody paiement paiement) {
        return paiementService.updatePaiement(id, paiement);
    }

    /**
     * Supprimer un paiement par ID.
     */
    @DeleteMapping("/{id}")
    public void deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
    }
}
