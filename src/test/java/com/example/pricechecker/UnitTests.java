package com.example.pricechecker;

import com.example.pricechecker.application.SearchUseCase;
import com.example.pricechecker.application.SearchUseCasePetition;
import com.example.pricechecker.application.SearchUseCaseResponse;
import com.example.pricechecker.domain.entities.PriceDO;
import com.example.pricechecker.domain.services.PriceService;
import com.example.pricechecker.domain.repositories.PriceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UnitTests {

    PriceRepository priceRepository = Mockito.mock(PriceRepository.class);
    PriceService priceService = new PriceService(priceRepository);


    @Test
    void ShouldPassFirstTest() {

        when(priceRepository.findAll()).thenReturn(getAllPrices());
        SearchUseCasePetition petition = SearchUseCasePetition.builder()
                .applicationDate(LocalDateTime.of(2020,06,14,10,00,00))
                .brandId("1")
                .productId("35455")
                .build();

        SearchUseCase useCase = new SearchUseCase(priceService);
        SearchUseCaseResponse response = useCase.execute(petition);

        SearchUseCaseResponse expected = SearchUseCaseResponse.builder()
                .productId("35455")
                .brandId("1")
                .priority("0")
                .startDate("2020-06-14-00.00.00")
                .endDate("2020-12-31-23.59.59")
                .finalPrice("35.50 EUR")
                .build();

        assertEquals(expected, response);
    }

    @Test
    void ShouldPassSecondTest() {

        when(priceRepository.findAll()).thenReturn(getAllPrices());
        SearchUseCasePetition petition = SearchUseCasePetition.builder()
                .applicationDate(LocalDateTime.of(2020,06,14,16,00,00))
                .brandId("1")
                .productId("35455")
                .build();

        SearchUseCase useCase = new SearchUseCase(priceService);
        SearchUseCaseResponse response = useCase.execute(petition);

        SearchUseCaseResponse expected = SearchUseCaseResponse.builder()
                .productId("35455")
                .brandId("1")
                .priority("1")
                .startDate("2020-06-14-15.00.00")
                .endDate("2020-06-14-18.30.00")
                .finalPrice("25.45 EUR")
                .build();

        assertEquals(expected, response);
    }

    @Test
    void ShouldPassThirdTest() {

        when(priceRepository.findAll()).thenReturn(getAllPrices());
        SearchUseCasePetition petition = SearchUseCasePetition.builder()
                .applicationDate(LocalDateTime.of(2020,06,14,21,00,00))
                .brandId("1")
                .productId("35455")
                .build();

        SearchUseCase useCase = new SearchUseCase(priceService);
        SearchUseCaseResponse response = useCase.execute(petition);

        SearchUseCaseResponse expected = SearchUseCaseResponse.builder()
                .productId("35455")
                .brandId("1")
                .priority("0")
                .startDate("2020-06-14-00.00.00")
                .endDate("2020-12-31-23.59.59")
                .finalPrice("35.50 EUR")
                .build();

        assertEquals(expected, response);
    }

    @Test
    void ShouldPassFourthTest() {

        when(priceRepository.findAll()).thenReturn(getAllPrices());
        SearchUseCasePetition petition = SearchUseCasePetition.builder()
                .applicationDate(LocalDateTime.of(2020,06,15,10,00,00))
                .brandId("1")
                .productId("35455")
                .build();

        SearchUseCase useCase = new SearchUseCase(priceService);
        SearchUseCaseResponse response = useCase.execute(petition);

        SearchUseCaseResponse expected = SearchUseCaseResponse.builder()
                .productId("35455")
                .brandId("1")
                .priority("1")
                .startDate("2020-06-15-00.00.00")
                .endDate("2020-06-15-11.00.00")
                .finalPrice("30.50 EUR")
                .build();

        assertEquals(expected, response);
    }

    @Test
    void ShouldPassFifthTest() {

        when(priceRepository.findAll()).thenReturn(getAllPrices());
        SearchUseCasePetition petition = SearchUseCasePetition.builder()
                .applicationDate(LocalDateTime.of(2020,06,16,21,00,00))
                .brandId("1")
                .productId("35455")
                .build();

        SearchUseCase useCase = new SearchUseCase(priceService);
        SearchUseCaseResponse response = useCase.execute(petition);

        SearchUseCaseResponse expected = SearchUseCaseResponse.builder()
                .productId("35455")
                .brandId("1")
                .priority("1")
                .startDate("2020-06-15-16.00.00")
                .endDate("2020-12-31-23.59.59")
                .finalPrice("38.95 EUR")
                .build();

        assertEquals(expected, response);
    }

    private List<PriceDO> getAllPrices(){

        return List.of(
                PriceDO.builder()
                        .brandId("1")
                        .startDate(LocalDateTime.of(2020,06,14,00,00,00))
                        .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                        .priceList("1")
                        .productId("35455")
                        .priority("0")
                        .price(35.50)
                        .currency("EUR")
                        .build(),

                PriceDO.builder()
                        .brandId("1")
                        .startDate(LocalDateTime.of(2020,06,14,15,00,00))
                        .endDate(LocalDateTime.of(2020,06,14,18,30,00))
                        .priceList("2")
                        .productId("35455")
                        .priority("1")
                        .price(25.45)
                        .currency("EUR")
                        .build(),

                PriceDO.builder()
                        .brandId("1")
                        .startDate(LocalDateTime.of(2020,06,15,00,00,00))
                        .endDate(LocalDateTime.of(2020,06,15,11,00,00))
                        .priceList("3")
                        .productId("35455")
                        .priority("1")
                        .price(30.50)
                        .currency("EUR")
                        .build(),

                PriceDO.builder()
                        .brandId("1")
                        .startDate(LocalDateTime.of(2020,06,15,16,00,00))
                        .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                        .priceList("4")
                        .productId("35455")
                        .priority("1")
                        .price(38.95)
                        .currency("EUR")
                        .build()

        );
    }

}
