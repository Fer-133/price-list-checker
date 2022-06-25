package com.example.pricechecker.infrastructure.db;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Prices")
public class PriceDB {

    @Id
    @Column(name = "PRICE_ID")
    private Long priceId;

    @Column(name = "BRAND_ID")
    private String brandId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private String priceList;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "LAST_UPDATE")
    private LocalDateTime lastUpdate;

    @Column(name = "LAST_UPDATE_BY")
    private String lastUpdateBy;

}
