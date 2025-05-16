package com.inditex.rater.dataaccess.config;

import com.inditex.rater.dataaccess.brand.repository.BrandJpaRepository;
import com.inditex.rater.dataaccess.product.repository.ProductJpaRepository;
import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.ports.output.repository.PriceListRepository;
import com.inditex.rater.domain.ports.output.repository.ProductRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "com.inditex.rater.domain.ports")
@Configuration
public class DataAccessTestConfiguration {

    @Bean
    public ProductRepository productRepository() {
        return Mockito.mock(ProductRepository.class);
    }

    @Bean
    public ProductJpaRepository productJpaRepository() {
        return Mockito.mock(ProductJpaRepository.class);
    }
    @Bean
    public BrandRepository brandRepository() {
        return Mockito.mock(BrandRepository.class);
    }

    @Bean
    public BrandJpaRepository brandJpaRepository() {
        return Mockito.mock(BrandJpaRepository.class);
    }
    @Bean
    public PriceListRepository priceListRepository() {
        return Mockito.mock(PriceListRepository.class);
    }

}
