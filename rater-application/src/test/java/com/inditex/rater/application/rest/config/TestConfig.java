package com.inditex.rater.application.rest.config;

import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.ports.output.repository.PriceListRepository;
import com.inditex.rater.domain.ports.output.repository.ProductRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public BrandRepository brandRepository(){
        return Mockito.mock(BrandRepository.class);
    }
    @Bean
    public ProductRepository productRepository(){
        return Mockito.mock(ProductRepository.class);
    }

    @Bean
    public PriceListRepository priceListRepository(){
        return Mockito.mock(PriceListRepository.class);
    }

}
