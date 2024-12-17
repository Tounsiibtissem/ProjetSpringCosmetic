package com.exemple.jpaapp1.model;

import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Produit")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Nom_Produit")
	private String nom_produit;
	@Column(name = "Description")
	private String description;
	@Column(name = "Prix")
	private double prix;
	@Column(name = "Stock")
	private String stock;
	
	@Lob // Annotation pour stocker de gros objets binaires
    @Column(name = "Image", columnDefinition = "BLOB") // Type de colonne BLOB
    private byte[] image;


	public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom_produit=" + nom_produit + ", description=" + description + ", prix=" + prix
				+ ", stock=" + stock + ", categorie=" + categorie + ", marque=" + marque + "]";
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	@ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
	
	@ManyToOne
    @JoinColumn(name = "idMarque")
    private Marque marque;

	

}
