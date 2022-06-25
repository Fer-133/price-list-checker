package com.example.pricechecker.infrastructure.rest;

import com.example.pricechecker.application.SearchUseCase;
import com.example.pricechecker.application.SearchUseCasePetition;
import com.example.pricechecker.application.SearchUseCaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class RestController {

    @Autowired
    SearchUseCase searchUseCase;


/*
    private final SearchUseCase searchUseCase;

    public RestController(SearchUseCase searchUseCase){
        this.searchUseCase = searchUseCase;
    }

 */

    @GetMapping("/prices/")
    public SearchUseCaseResponse searchPrice(
            @RequestBody String applicationDate,
            @RequestBody String productId,
            @RequestBody String brandId){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime dateTime = LocalDateTime.parse(applicationDate, formatter);

        SearchUseCasePetition petition = SearchUseCasePetition.builder()
                .applicationDate(dateTime)
                .productId(productId)
                .brandId(brandId)
                .build();

        return searchUseCase.execute(petition);
    }

}
