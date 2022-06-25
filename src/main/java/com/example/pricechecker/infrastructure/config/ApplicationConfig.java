package com.example.pricechecker.infrastructure.config;

import com.example.pricechecker.application.SearchUseCase;
import com.example.pricechecker.domain.repositories.PriceRepository;
import com.example.pricechecker.domain.services.PriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PriceService priceService(PriceRepository priceRepository) {
        return new PriceService(priceRepository);
    }

    @Bean
    public SearchUseCase searchUseCase(PriceService priceService) {
        return new SearchUseCase(priceService);
    }

}
