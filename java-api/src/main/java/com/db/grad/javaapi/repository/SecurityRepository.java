package com.db.grad.javaapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
        List<Security> findByMaturityDateBetween(LocalDate startDate, LocalDate endDate);
        @Query("SELECT trade FROM Trade trade WHERE trade.security = :security")
        List<Trade> getTradesForSecurity(Long securityId);
}
