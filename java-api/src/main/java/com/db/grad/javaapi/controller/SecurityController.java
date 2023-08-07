package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Dogs;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import com.db.grad.javaapi.service.DogsService;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class SecurityController {
    private SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService ss) {
        securityService = ss;
    }

    @PostMapping("/security")
    public Security createSecurity(@Valid @RequestBody Security security) {
        return securityService.saveSecurity(security);
    }

    @GetMapping("/security")
    public List<Security> getAllSecurities() {
        return securityService.getAllSecurities();
    }

    @GetMapping("/security/{id}")
    public ResponseEntity<Security> getSecurityById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Security security = securityService.findSecurityById(id);
        return ResponseEntity.ok().body(security);
    }

    @PutMapping("/security/{id}")
    public ResponseEntity<Security> updateSecurity(@PathVariable(value = "id") Long id,
                                          @Valid @RequestBody Security security) throws ResourceNotFoundException {

        final Security updatedSecurity = securityService.updateSecurityDetails(id, security);
        return ResponseEntity.ok(updatedSecurity);
    }

    @DeleteMapping("/security/{id}")
    public Map<String, Boolean> deleteSecurity(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Security security = securityService.deleteSecurity(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
