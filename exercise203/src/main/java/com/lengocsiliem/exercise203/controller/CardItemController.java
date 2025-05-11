package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.CardItem;
import com.lengocsiliem.exercise203.service.CardItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/card-items")
public class CardItemController {

    @Autowired
    private CardItemService cardItemService;

    @GetMapping
    public ResponseEntity<List<CardItem>> getAllCardItems() {
        List<CardItem> cardItems = cardItemService.getAllCardItems();
        return new ResponseEntity<>(cardItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardItem> getCardItemById(@PathVariable UUID id) {
        Optional<CardItem> cardItem = cardItemService.getCardItemById(id);
        return cardItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<CardItem> createCardItem(@RequestBody CardItem cardItem) {
        CardItem createdCardItem = cardItemService.createCardItem(cardItem);
        return new ResponseEntity<>(createdCardItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardItem> updateCardItem(@PathVariable UUID id, @RequestBody CardItem cardItemDetails) {
        CardItem updatedCardItem = cardItemService.updateCardItem(id, cardItemDetails);
        return new ResponseEntity<>(updatedCardItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardItem(@PathVariable UUID id) {
        cardItemService.deleteCardItem(id);
        return ResponseEntity.noContent().build();
    }
}
