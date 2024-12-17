package com.exemple.jpaapp1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.jpaapp1.model.Marque;
import com.exemple.jpaapp1.model.Produit;
import com.exemple.jpaapp1.repository.MarqueRepository;

import jakarta.transaction.Transactional;
@Service
public class MarqueService {
	  @Autowired
	    private MarqueRepository marqueRepository;

	    public Iterable<Marque> getAllMarques() {
	        return marqueRepository.findAll();
	    }

	    public Marque getMarqueById(Long id) {
	        return marqueRepository.findAllById(id).orElse(null);
	    }

	    public Marque createMarque(Marque marque) {
	        return marqueRepository.save(marque);
	    }

	    public Marque updateMarque(Long id, Marque marqueDetails) {
	        Marque marque = marqueRepository.findById(id).orElse(null);
	        if (marque != null) {
	            marque.setNom_Marque(marqueDetails.getNom_Marque());
	            // Sauvegarder la marque mise à jour
	            return marqueRepository.save(marque);
	        }
	        return null;
	    }

	    @Transactional
	    public void deleteMarque(Long id) {
	        marqueRepository.deleteById(id);
	    }
	    
	  

		

}
