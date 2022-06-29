package com.example.pricechecker;

import com.example.pricechecker.application.SearchUseCaseResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PriceCheckerApplication.class)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldWorksFirstCase() {

        ResponseEntity<SearchUseCaseResponse> res  = restTemplate.getForEntity("/prices?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1", SearchUseCaseResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchUseCaseResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-00.00.00", response.getStartDate());
        assertEquals("2020-12-31-23.59.59", response.getEndDate());
        assertEquals("0", response.getPriority());
        assertEquals("35.50 EUR", response.getFinalPrice());

    }

    @Test
    public void shouldWorksSecondCase() {

        ResponseEntity<SearchUseCaseResponse> res  = restTemplate.getForEntity("/prices?applicationDate=2020-06-14-16.00.00&productId=35455&brandId=1", SearchUseCaseResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchUseCaseResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-15.00.00", response.getStartDate());
        assertEquals("2020-06-14-18.30.00", response.getEndDate());
        assertEquals("1", response.getPriority());
        assertEquals("25.45 EUR", response.getFinalPrice());

    }

    @Test
    public void shouldWorksThirdCase() {

        ResponseEntity<SearchUseCaseResponse> res  = restTemplate.getForEntity("/prices?applicationDate=2020-06-14-21.00.00&productId=35455&brandId=1", SearchUseCaseResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchUseCaseResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-14-00.00.00", response.getStartDate());
        assertEquals("2020-12-31-23.59.59", response.getEndDate());
        assertEquals("0", response.getPriority());
        assertEquals("35.50 EUR", response.getFinalPrice());

    }

    @Test
    public void shouldWorksFourthCase() {

        ResponseEntity<SearchUseCaseResponse> res  = restTemplate.getForEntity("/prices?applicationDate=2020-06-15-10.00.00&productId=35455&brandId=1", SearchUseCaseResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchUseCaseResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-15-00.00.00", response.getStartDate());
        assertEquals("2020-06-15-11.00.00", response.getEndDate());
        assertEquals("1", response.getPriority());
        assertEquals("30.50 EUR", response.getFinalPrice());

    }

    @Test
    public void shouldWorksFifthCase() {

        ResponseEntity<SearchUseCaseResponse> res  = restTemplate.getForEntity("/prices?applicationDate=2020-06-16-21.00.00&productId=35455&brandId=1", SearchUseCaseResponse.class);

        assertTrue(res.getStatusCode().is2xxSuccessful());

        SearchUseCaseResponse response = res.getBody();

        assertEquals("35455", response.getProductId());
        assertEquals("1", response.getBrandId());
        assertEquals("2020-06-15-16.00.00", response.getStartDate());
        assertEquals("2020-12-31-23.59.59", response.getEndDate());
        assertEquals("1", response.getPriority());
        assertEquals("38.95 EUR", response.getFinalPrice());

    }

}
