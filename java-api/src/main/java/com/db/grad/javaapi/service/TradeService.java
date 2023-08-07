package com.db.grad.javaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import com.db.grad.javaapi.model.Security;

@Service
public class TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    public Optional<Trade> getTradeById(Long id) {
        return tradeRepository.findById(id);
    }

    public Trade createTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Trade updateTrade(Long id, Trade trade) {
        Optional<Trade> existingTrade = tradeRepository.findById(id);
        if (existingTrade.isPresent()) {
            Trade updatedTrade = existingTrade.get();
            updatedTrade.setBookId(trade.getBookId());
            updatedTrade.setCounterpartyId(trade.getCounterpartyId());
            updatedTrade.setSecurity(trade.getSecurity()); // Set the Security object
            updatedTrade.setQuantity(trade.getQuantity());
            updatedTrade.setStatus(trade.getStatus());
            updatedTrade.setPrice(trade.getPrice());
            updatedTrade.setBuySell(trade.getBuySell());
            updatedTrade.setTradeDate(trade.getTradeDate());
            updatedTrade.setSettlementDate(trade.getSettlementDate());
            // Update other properties as needed
            return tradeRepository.save(updatedTrade);
        } else {
            throw new IllegalArgumentException("Trade not found with id: " + id);
        }
    }
    

    public void deleteTrade(Long id) {
        tradeRepository.deleteById(id);
    }

    public List<Trade> getTradesBySecurityId(Long securityId) {
        return tradeRepository.findBySecurityId(securityId);
    }

    public Security getSecurityForTrade(Long tradeId) {
        Optional<Trade> trade = tradeRepository.findById(tradeId);
        if (trade.isPresent()) {
            return trade.get().getSecurity();
        } else {
            throw new IllegalArgumentException("Trade not found with id: " + tradeId);
        }
    }

   
}
