package com.exemple.jpaapp1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Commande")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Total")
	private String total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
	 @ManyToOne
	    @JoinColumn(name = "idUser")
	    private User user;
	 @Override
	public String toString() {
		return "Commande [id=" + id + ", total=" + total + ", user=" + user + ", paiements=" + paiements + "]";
	}

	@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
	 private List<paiement> paiements;
	public void setTotalProduit(String total2) {
		// TODO Auto-generated method stub
		
	}


}
