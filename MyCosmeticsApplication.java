package com.exemple.jpaapp1;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.exemple.jpaapp1.model.Produit;
import com.exemple.jpaapp1.repository.ProduitRepository;

@RestController
@SpringBootApplication

public class MyCosmeticsApplication {
	@Autowired
    private ProduitRepository prodrepo;
	

	public static void main(String[] args) {
		SpringApplication.run(MyCosmeticsApplication.class, args);
	}
	@GetMapping("/listproduit")
    public List<Produit> getAllProduits() {
        return (List<Produit>) prodrepo.findAll();
    }
	

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable int id) {
        Optional<Produit> produit = ProduitRepository.getProduitById(id);
        return produit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addproduit")
    public Produit createProduit(@RequestBody Produit produit) {
        return ProduitRepository.saveProduit(produit);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable int id, @RequestBody Produit produitDetails) throws AccountNotFoundException {
        Produit updatedProduit = ProduitRepository.updateProduit(id, produitDetails);
		return ResponseEntity.ok(updatedProduit);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable int id) {
        ProduitRepository.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }


}
