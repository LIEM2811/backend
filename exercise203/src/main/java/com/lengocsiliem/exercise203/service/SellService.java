package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Sell;

public interface SellService {
    List<Sell> getAllSells();

    Optional<Sell> getSellById(UUID id);

    Sell createSell(Sell sell);

    Sell updateSell(UUID id, Sell sellDetails);

    void deleteSell(UUID id);
}
