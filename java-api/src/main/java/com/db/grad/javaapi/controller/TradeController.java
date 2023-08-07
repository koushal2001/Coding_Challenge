package com.db.grad.javaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import com.db.grad.javaapi.model.Security;

import java.util.Optional;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable Long id) {
        Optional<Trade> trade = tradeService.getTradeById(id);
        if (trade.isPresent()) {
            return new ResponseEntity<>(trade.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{tradeId}/security")
    public ResponseEntity<Security> getSecurityForTrade(@PathVariable Long tradeId) {
        Security security = tradeService.getSecurityForTrade(tradeId);
        return new ResponseEntity<>(security, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
        Trade createdTrade = tradeService.createTrade(trade);
        return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable Long id, @RequestBody Trade trade) {
        Trade updatedTrade = tradeService.updateTrade(id, trade);
        return new ResponseEntity<>(updatedTrade, HttpStatus.OK);
    }

}
