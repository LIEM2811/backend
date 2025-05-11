package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Card;

public interface CardService {
    List<Card> getAllCards();

    Card getCardById(UUID id);

    Card createCard(Card card);

    void deleteCard(UUID id);
}
