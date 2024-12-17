package com.exemple.jpaapp1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name = "Marque")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Marque {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "Nom_Marque")
		private String nom_Marque;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom_Marque() {
			return nom_Marque;
		}
		public void setNom_Marque(String nom_Marque) {
			this.nom_Marque = nom_Marque;
		}
		@Override
		public String toString() {
			return "Categorie [id=" + id + ", nom_Marque=" + nom_Marque + "]";
		}
		
		
	}
