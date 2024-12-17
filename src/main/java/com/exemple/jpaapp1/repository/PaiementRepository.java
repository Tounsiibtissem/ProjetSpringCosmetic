package com.exemple.jpaapp1.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.jpaapp1.model.paiement;

@Repository
public interface PaiementRepository extends JpaRepository<paiement, Long> {
}
