package com.db.grad.javaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.repository.TradeRepository;

@Service
public class SecurityService {

    @Autowired
    private SecurityRepository securityRepository;
    private final TradeRepository tradeRepository;

    public SecurityService(SecurityRepository securityRepository, TradeRepository tradeRepository) {
        this.securityRepository = securityRepository;
        this.tradeRepository = tradeRepository;
    }
    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    public Optional<Security> getSecurityById(Long id) {
        return securityRepository.findById(id);
    }

    public List<Security> getSecuritiesByDateRange(LocalDate startDate, LocalDate endDate) {
        return securityRepository.findByMaturityDateBetween(startDate, endDate);
    }

    public Security createSecurity(Security security) {
        return securityRepository.save(security);
    }

    public Security updateSecurity(Long id, Security security) {
        Optional<Security> existingSecurity = securityRepository.findById(id);
        if (existingSecurity.isPresent()) {
            Security updatedSecurity = existingSecurity.get();
            updatedSecurity.setISIN(security.getISIN());
            updatedSecurity.setCUSIP(security.getCUSIP());
                                                                // Update other properties as needed
            return securityRepository.save(updatedSecurity);
        } else {
            throw new IllegalArgumentException("Security not found with id: " + id);
        }
    }
    
    public List<Trade> getTradesForSecurity(Long securityId) {

        return tradeRepository.findBySecurityId(securityId);
    }

    public void deleteSecurity(Long id) {
        securityRepository.deleteById(id);
    }
}

