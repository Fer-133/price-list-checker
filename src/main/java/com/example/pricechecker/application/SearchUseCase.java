package com.example.pricechecker.application;

import com.example.pricechecker.domain.entities.PriceDO;
import com.example.pricechecker.domain.services.PriceService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SearchUseCase {

    private PriceService priceService;

    public SearchUseCase (PriceService service) {
        this.priceService = service;
    }

    public  SearchUseCaseResponse execute (SearchUseCasePetition petition){

        PriceDO priceDO = priceService.searchPrice(petition.getApplicationDate(), petition.getProductId(), petition.getBrandId());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

        return SearchUseCaseResponse.builder()
                .productId(priceDO.getProductId())
                .brandId(priceDO.getBrandId())
                .priority(priceDO.getPriority())
                .startDate(priceDO.getStartDate().format(dateTimeFormatter))
                .endDate(priceDO.getEndDate().format(dateTimeFormatter))
                .finalPrice(String.format(Locale.US, "%,.2f",priceDO.getPrice()) + " " + priceDO.getCurrency())
                .build();
    }

}
