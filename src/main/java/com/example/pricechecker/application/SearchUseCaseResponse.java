package com.example.pricechecker.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchUseCaseResponse {

    private final String productId;
    private final String brandId;
    private final String priority;
    private final String startDate;
    private final String endDate;
    private final String finalPrice;

}
