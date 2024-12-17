package com.exemple.jpaapp1.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;

    private String modePaiement; // Ex. "Carte bancaire", "PayPal", etc.

    private LocalDateTime datePaiement;

    @ManyToOne
    @JoinColumn(name = "id_commande", nullable = false)
    private Commande commande;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public LocalDateTime getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(LocalDateTime datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "paiement [id=" + id + ", montant=" + montant + ", modePaiement=" + modePaiement + ", datePaiement="
				+ datePaiement + ", commande=" + commande + "]";
	}

	public Object getMethode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStatut() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMethode(Object methode) {
		// TODO Auto-generated method stub
		
	}

	public void setStatut(Object statut) {
		// TODO Auto-generated method stub
		
	}

    
}
