package com.lengocsiliem.exercise203.service.impl;

import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Card;
import com.lengocsiliem.exercise203.repository.CardRepository;
import com.lengocsiliem.exercise203.service.CardService;

import java.util.List;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(UUID id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(UUID id) {
        cardRepository.deleteById(id);
    }
}
