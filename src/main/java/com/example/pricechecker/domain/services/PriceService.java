package com.example.pricechecker.domain.services;

import com.example.pricechecker.domain.entities.PriceDO;
import com.example.pricechecker.domain.repositories.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

public class PriceService {

    private final PriceRepository priceRepository;
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    public PriceDO searchPrice(LocalDateTime applicationDate, String productId, String brandId) {

        Optional<PriceDO> priceDOOptional = priceRepository.findAll().stream()
                .filter(p -> p.getProductId().equals(productId))
                .filter(p -> p.getBrandId().equals(brandId))
                .filter(p -> p.getStartDate().isBefore(applicationDate))
                .filter(p -> p.getEndDate().isAfter(applicationDate))
                .max(Comparator.comparing(p -> p.getPriority()));

        if (priceDOOptional.isPresent()){
            return priceDOOptional.get();
        } else {
            throw new RuntimeException();
        }

    }
}
