package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.db.grad.javaapi.model.Counterparty;

@Repository
public interface CounterpartyRepository extends JpaRepository<Counterparty, Long> {
    // Add custom query methods if needed
}
