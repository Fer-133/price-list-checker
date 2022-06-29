package com.example.pricechecker.domain.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PriceDO {

    private final String brandId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String priceList;
    private final String productId;
    private final String priority;
    private final Double price;
    private final String currency;

    /*public String getFinalPrice() {
        return this.price + " " + this.currency;
    }*/

}
