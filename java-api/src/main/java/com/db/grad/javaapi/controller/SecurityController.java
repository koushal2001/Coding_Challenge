package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional; 

@RestController
@RequestMapping("/api/securities")
public class SecurityController {

    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping
    public ResponseEntity<List<Security>> getAllSecurities() {
        List<Security> securities = securityService.getAllSecurities();
        return new ResponseEntity<>(securities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Security> getSecurityById(@PathVariable Long id) {
    Optional<Security> optionalSecurity = securityService.getSecurityById(id);
        
        if (optionalSecurity.isPresent()) {
            Security security = optionalSecurity.get();
            return new ResponseEntity<>(security, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/by-date")
    public ResponseEntity<List<Security>> getSecuritiesByDate(@RequestParam String startDate, @RequestParam String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedStartDate = LocalDate.parse(startDate, formatter);
        LocalDate parsedEndDate = LocalDate.parse(endDate, formatter);

        List<Security> securities = securityService.getSecuritiesByDateRange(parsedStartDate, parsedEndDate);
        return new ResponseEntity<>(securities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Security> createSecurity(@RequestBody Security security) {
        Security createdSecurity = securityService.createSecurity(security);
        return new ResponseEntity<>(createdSecurity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Security> updateSecurity(@PathVariable Long id, @RequestBody Security security) {
        Security updatedSecurity = securityService.updateSecurity(id, security);
        return new ResponseEntity<>(updatedSecurity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecurity(@PathVariable Long id) {
        securityService.deleteSecurity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
