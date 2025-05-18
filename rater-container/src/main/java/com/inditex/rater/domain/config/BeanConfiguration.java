package com.inditex.rater.domain.config;

import com.inditex.rater.application.rest.mapper.RateMapper;
import com.inditex.rater.application.rest.mapper.RateMapperImpl;
import com.inditex.rater.dataaccess.brand.mapper.BrandDataAccessMapper;
import com.inditex.rater.dataaccess.brand.mapper.BrandDataAccessMapperImpl;
import com.inditex.rater.dataaccess.pricelist.mapper.PriceListDataAccessMapper;
import com.inditex.rater.dataaccess.pricelist.mapper.PriceListDataAccessMapperImpl;
import com.inditex.rater.dataaccess.product.mapper.ProductDataAccessMapper;
import com.inditex.rater.dataaccess.product.mapper.ProductDataAccessMapperImpl;
import com.inditex.rater.domain.RateDomainService;
import com.inditex.rater.domain.RateDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RateDomainService rateDomainService() {
        return new RateDomainServiceImpl();
    }

    @Bean
    public RateMapper rateMapper() {
        return new RateMapperImpl();
    }

    @Bean
    public BrandDataAccessMapper brandDataAccessMapper() {
        return new BrandDataAccessMapperImpl();
    }
    @Bean
    public ProductDataAccessMapper productDataAccessMapper() {
        return new ProductDataAccessMapperImpl();
    }
    @Bean
    public PriceListDataAccessMapper priceListDataAccessMapper() {
        return new PriceListDataAccessMapperImpl();
    }
}
