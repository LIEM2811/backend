package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Sell;
import com.lengocsiliem.exercise203.repository.SellRepository;
import com.lengocsiliem.exercise203.service.SellService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SellServiceImpl implements SellService {

    @Autowired
    private SellRepository sellRepository;

    @Override
    public List<Sell> getAllSells() {
        return sellRepository.findAll();
    }

    @Override
    public Optional<Sell> getSellById(UUID id) {
        return sellRepository.findById(id);
    }

    @Override
    public Sell createSell(Sell sell) {
        return sellRepository.save(sell);
    }

    @Override
    public Sell updateSell(UUID id, Sell sellDetails) {
        Sell sell = sellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sell not found"));
        sell.setProduct(sellDetails.getProduct());
        sell.setPrice(sellDetails.getPrice());
        sell.setQuantity(sellDetails.getQuantity());
        return sellRepository.save(sell);
    }

    @Override
    public void deleteSell(UUID id) {
        sellRepository.deleteById(id);
    }
}
