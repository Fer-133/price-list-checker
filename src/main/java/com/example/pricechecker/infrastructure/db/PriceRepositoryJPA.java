package com.example.pricechecker.infrastructure.db;

import com.example.pricechecker.domain.entities.PriceDO;
import com.example.pricechecker.domain.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceRepositoryJPA implements PriceRepository {

    @Autowired
    PriceJPAInterface priceJPAInterface;

    public List<PriceDO> findAll() {
        List<PriceDB> pricesDB = priceJPAInterface.findAll();

        List<PriceDO> pricesDO = new ArrayList<>();

        for (PriceDB priceDB : pricesDB){
            PriceDO priceDO = PriceDO.builder()
                    .brandId(priceDB.getBrandId())
                    .startDate(priceDB.getStartDate())
                    .endDate(priceDB.getEndDate())
                    .priceList(priceDB.getPriceList())
                    .productId(priceDB.getProductId())
                    .priority(priceDB.getPriority().toString())
                    .price(priceDB.getPrice())
                    .currency(priceDB.getCurrency())
                    .build();

            pricesDO.add(priceDO);
        }

        return pricesDO;
    }

}
