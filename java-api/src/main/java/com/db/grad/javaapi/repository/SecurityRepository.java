package com.db.grad.javaapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.db.grad.javaapi.model.Security;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
        List<Security> findByMaturityDateBetween(LocalDate startDate, LocalDate endDate);

}
