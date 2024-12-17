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

import com.exemple.jpaapp1.model.LigneCommande;
import com.exemple.jpaapp1.service.LigneCommandeService;

@RestController
@RequestMapping("/api/lignesCommande")
public class LigneCommandeController {

    @Autowired
    private LigneCommandeService ligneCommandeService;

    @GetMapping
    public List<LigneCommande> getAllLignesCommande() {
        return (List<LigneCommande>) ligneCommandeService.getAllLignesCommande();
    }

    @GetMapping("/{id}")
    public LigneCommande getLigneCommandeById(@PathVariable Long id) {
        return ligneCommandeService.getLigneCommandeById(id);
    }

    @PostMapping
    public LigneCommande createLigneCommande(@RequestBody LigneCommande ligneCommande) {
        return ligneCommandeService.createLigneCommande(ligneCommande);
    }

    @PutMapping("/{id}")
    public LigneCommande updateLigneCommande(@PathVariable Long id, @RequestBody LigneCommande ligneCommande) {
        return ligneCommandeService.updateLigneCommande(id, ligneCommande);
    }

    @DeleteMapping("/{id}")
    public void deleteLigneCommande(@PathVariable Long id) {
        ligneCommandeService.deleteLigneCommande(id);
    }
}

