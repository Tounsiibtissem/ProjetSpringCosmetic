package com.exemple.jpaapp1.controller;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exemple.jpaapp1.service.ProduitService;

import com.exemple.jpaapp1.model.Produit;
import com.exemple.jpaapp1.repository.ProduitRepository;
@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "http://localhost:4200") // Autoriser cette origine
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping
    public Iterable<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Produit produit = produitService.getProduitById(id);
        return produit != null ? ResponseEntity.ok(produit) : ResponseEntity.notFound().build();
    }
    

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }
    
    

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        Produit updatedProduit = produitService.updateProduit(id, produitDetails);
        return updatedProduit != null ? ResponseEntity.ok(updatedProduit) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/categorie/{categorieId}")
    public ResponseEntity<List<Produit>> getProduitsByCategorie(@PathVariable Long categorieId) {
        List<Produit> produits = produitRepository.findByCategorieID(categorieId);
        
        if (produits.isEmpty()) {
            return ResponseEntity.noContent().build(); // Si aucune produit n'est trouvé, retourner un code 204
        }
        
        return ResponseEntity.ok(produits); // Retourner les produits avec un code 200
    }
    
 // Méthode pour récupérer les produits par nom de catégorie
    @GetMapping("/categorieNom/{categorieNom}")
    public ResponseEntity<List<Produit>> getProduitsByCategorieNom(@PathVariable String categorieNom) {
        List<Produit> produits = produitRepository.findByCategorieNom(categorieNom);
        
        if (produits.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retourner 204 si aucun produit trouvé
        }
        
        return ResponseEntity.ok(produits); // Retourner les produits avec un code 200
    }
    
    @PostMapping("/{id}/image")
    public ResponseEntity<?> uploadImage(
            @PathVariable Long id, 
            @RequestParam("image") MultipartFile file) {
        try {
            // Validate file
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }

            // Save file to database or filesystem
            // Example: Save to database
            Produit product = produitRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Product not found"));
            product.setImage(file.getBytes());
            produitRepository.save(product);

            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        byte[] image = produit.getImage(); // Assuming `getImage()` returns a byte array
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }




    
    

    
   

}

