package com.exemple.jpaapp1.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.exemple.jpaapp1.model.Marque;
import com.exemple.jpaapp1.service.MarqueService;

@RestController
@RequestMapping("/api/marques")
@CrossOrigin(origins = "http://localhost:4200") // Autoriser cette origine
public class MarqueController {
	 @Autowired
	    private MarqueService marqueService;

	    @GetMapping
	    public Iterable<Marque> getAllmarques() {
	        return marqueService.getAllMarques();
	    }

	    @GetMapping("/{id}")
	    public Marque getMarqueById(@PathVariable Long id) {
	        return marqueService.getMarqueById(id);
	    }

	    @PostMapping
	    public Marque createMarque(@RequestBody Marque marque) {
	        return marqueService.createMarque(marque);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Marque> updateMarque(@PathVariable Long id, @RequestBody Marque marque) {
	        Marque updatedMarque = marqueService.updateMarque(id, marque);
	        if (updatedMarque != null) {
	            return ResponseEntity.ok(updatedMarque);
	        }
	        return ResponseEntity.notFound().build();
	    }



	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteMarque(@PathVariable Long id) {
	        try {
	        	marqueService.deleteMarque(id);
	            return ResponseEntity.ok().build();
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting");
	        }
	    }
	    

}
