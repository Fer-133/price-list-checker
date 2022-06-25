package com.example.pricechecker.infrastructure.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceJPAInterface extends JpaRepository<PriceDB, Long> {
}
