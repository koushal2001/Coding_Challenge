package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Dogs;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private SecurityRepository securityRepository;

    @Transactional
    public Security saveSecurity(Security security)
    {
        return securityRepository.save(security);
    }

    @Transactional
    public List<Security> getAllSecurities()
    {
        return securityRepository.findAll();
    }

    @Transactional
    public Security findSecurityById(long id ) throws ResourceNotFoundException
    {
        Security security = securityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));
        return security;
    }

    public Security updateSecurityDetails( long id, Security newSecurityDetails ) throws ResourceNotFoundException
    {
        Security securityToUpdate = securityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));

        securityToUpdate.setCoupon(newSecurityDetails.getCoupon());
        securityToUpdate.setType(newSecurityDetails.getType());
        securityToUpdate.setMaturityDate(newSecurityDetails.getMaturityDate());
        securityToUpdate.setFaceValue(newSecurityDetails.getFaceValue());
        securityToUpdate.setIssuer(newSecurityDetails.getIssuer());
        securityToUpdate.setStatus(newSecurityDetails.getStatus());
        securityToUpdate.setCUSIP(newSecurityDetails.getCUSIP());
        securityToUpdate.setISIN(newSecurityDetails.getISIN());

        final Security updatedSecurity = securityRepository.save(securityToUpdate);

        return updatedSecurity;
    }

    @Transactional
    public Security deleteSecurity( long id ) throws ResourceNotFoundException
    {
        Security security = securityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security not found for this id :: " + id));

        securityRepository.delete(security);

        return security;
    }
}
