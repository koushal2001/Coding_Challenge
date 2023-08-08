package com.db.grad.javaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.BookService;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/trades")
@CrossOrigin(origins = "http://localhost:3000")

public class TradeController {

    private final TradeService tradeService;
    private BookService bookService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
        this.bookService = bookService;
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

    @GetMapping("/by-book/{bookId}")
    public ResponseEntity<List<Trade>> getTradesForBook(@PathVariable Long bookId) {
        List<Trade> trades = tradeService.getTradesForBook(bookId);
        return ResponseEntity.ok(trades);
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
