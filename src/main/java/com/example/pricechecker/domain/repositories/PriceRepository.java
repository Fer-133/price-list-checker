package com.example.pricechecker.domain.repositories;

import com.example.pricechecker.domain.entities.PriceDO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PriceRepository {

    List<PriceDO> findAll();

}
