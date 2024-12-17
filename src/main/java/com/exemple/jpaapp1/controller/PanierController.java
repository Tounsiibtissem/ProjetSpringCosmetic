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

import com.exemple.jpaapp1.service.PanierService;
import com.exemple.jpaapp1.model.Panier;
@RestController
@RequestMapping("/api/paniers")
public class PanierController {

    @Autowired
    private PanierService panierService;

    @GetMapping
    public List<Panier> getAllPaniers() {
        return (List<Panier>) panierService.getAllPaniers();
    }

    @GetMapping("/{id}")
    public Panier getPanierById(@PathVariable Long id) {
        return panierService.getPanierById(id);
    }

    @PostMapping
    public Panier createPanier(@RequestBody Panier panier) {
        return panierService.createPanier(panier);
    }

    @PutMapping("/{id}")
    public Panier updatePanier(@PathVariable Long id, @RequestBody Panier panier) {
        return panierService.updatePanier(id, panier);
    }

    @DeleteMapping("/{id}")
    public void deletePanier(@PathVariable Long id) {
        panierService.deletePanier(id);
    }
}
