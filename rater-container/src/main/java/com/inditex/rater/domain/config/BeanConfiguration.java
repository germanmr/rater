package com.inditex.rater.domain.config;

import com.inditex.rater.application.rest.mapper.RateMapper;
import com.inditex.rater.application.rest.mapper.RateMapperImpl;
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
}
