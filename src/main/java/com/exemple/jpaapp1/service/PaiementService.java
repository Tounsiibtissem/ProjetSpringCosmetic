package com.exemple.jpaapp1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.jpaapp1.model.paiement;
import com.exemple.jpaapp1.repository.PaiementRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class PaiementService {

    private final PaiementRepository PaiementRepository = null;

    public List<paiement> getAllPaiements() {
        return PaiementRepository.findAll();
    }

    public paiement getPaiementById(Long id) {
        return PaiementRepository.findById(id).orElse(null);
    }

    public paiement createPaiement(paiement paiement) {
        return PaiementRepository.save(paiement);
    }

    public paiement updatePaiement(Long id, paiement paiementDetails) {
        paiement paiement = PaiementRepository.findById(id).orElse(null);

        if (paiement != null) {
            paiement.setMontant(paiementDetails.getMontant());
            paiement.setMethode(paiementDetails.getMethode());
            paiement.setStatut(paiementDetails.getStatut());
            paiement.setDatePaiement(paiementDetails.getDatePaiement());
            paiement.setCommande(paiementDetails.getCommande());
            return PaiementRepository.save(paiement);
        }
        return null;
    }
    @Transactional
    public void deletePaiement(Long id) {
        PaiementRepository.deleteById(id);
    }
}
