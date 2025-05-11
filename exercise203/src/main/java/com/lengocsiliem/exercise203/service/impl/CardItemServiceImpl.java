package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.CardItem;
import com.lengocsiliem.exercise203.repository.CardItemRepository;
import com.lengocsiliem.exercise203.service.CardItemService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardItemServiceImpl implements CardItemService {

    @Autowired
    private CardItemRepository cardItemRepository;

    @Override
    public List<CardItem> getAllCardItems() {
        return cardItemRepository.findAll();
    }

    @Override
    public Optional<CardItem> getCardItemById(UUID id) {
        return cardItemRepository.findById(id);
    }

    @Override
    public CardItem createCardItem(CardItem cardItem) {
        return cardItemRepository.save(cardItem);
    }

    @Override
    public CardItem updateCardItem(UUID id, CardItem cardItemDetails) {
        CardItem cardItem = cardItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card Item not found"));
        cardItem.setCard(cardItemDetails.getCard());
        cardItem.setProduct(cardItemDetails.getProduct());
        cardItem.setQuantity(cardItemDetails.getQuantity());
        return cardItemRepository.save(cardItem);
    }

    @Override
    public void deleteCardItem(UUID id) {
        cardItemRepository.deleteById(id);
    }
}
