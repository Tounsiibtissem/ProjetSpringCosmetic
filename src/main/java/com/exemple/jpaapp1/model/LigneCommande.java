package com.exemple.jpaapp1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "LigneCommande")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Quantite")
    private String Quantite;

    @ManyToOne
    @JoinColumn(name = "idCommande") // Foreign key to the Commande entity
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "idProduit") // Foreign key to the Produit entity
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "idPanier") // Foreign key to the Panier entity
    private Panier panier;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantite() {
        return Quantite;
    }

    public void setQuantite(String quantite) {
        Quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    @Override
    public String toString() {
        return "LigneCommande [id=" + id + ", Quantite=" + Quantite + ", commande=" + commande
                + ", produit=" + produit + ", panier=" + panier + "]";
    }
}
