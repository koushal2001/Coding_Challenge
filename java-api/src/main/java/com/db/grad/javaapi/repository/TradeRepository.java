package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findBySecurityId(Long securityId);
    List<Trade> findByBookId(Long bookId);

}
