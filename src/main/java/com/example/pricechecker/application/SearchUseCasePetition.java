package com.example.pricechecker.application;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SearchUseCasePetition {

    private final LocalDateTime applicationDate;
    private final String productId;
    private final String brandId;

}
