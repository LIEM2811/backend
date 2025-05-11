package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.Sell;
import com.lengocsiliem.exercise203.service.SellService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sells")
public class SellController {

    @Autowired
    private SellService sellService;

    @GetMapping
    public List<Sell> getAllSells() {
        return sellService.getAllSells();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sell> getSellById(@PathVariable UUID id) {
        return sellService.getSellById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Sell createSell(@RequestBody Sell sell) {
        return sellService.createSell(sell);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sell> updateSell(@PathVariable UUID id,
            @RequestBody Sell sellDetails) {
        Sell updatedSell = sellService.updateSell(id, sellDetails);
        return ResponseEntity.ok(updatedSell);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSell(@PathVariable UUID id) {
        sellService.deleteSell(id);
        return ResponseEntity.noContent().build();
    }
}
