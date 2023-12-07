package com.example.springmodels.services;

import com.example.springmodels.models.Price;
import com.example.springmodels.repos.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Optional<Price> getPriceById(Long id) {
        return priceRepository.findById(id);
    }

    public Price savePrice(Price price) {
        return priceRepository.save(price);
    }

    public void deletePrice(Long id) {
        priceRepository.deleteById(id);
    }
}
