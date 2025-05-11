package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.CardItem;

public interface CardItemService {
    List<CardItem> getAllCardItems();

    Optional<CardItem> getCardItemById(UUID id);

    CardItem createCardItem(CardItem cardItem);

    CardItem updateCardItem(UUID id, CardItem cardItemDetails);

    void deleteCardItem(UUID id);
}
