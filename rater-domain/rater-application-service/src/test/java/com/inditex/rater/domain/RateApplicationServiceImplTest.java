package com.inditex.rater.domain;

import com.inditex.rater.domain.config.TestConfig;
import com.inditex.rater.domain.dto.RateProductRequest;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.exception.BrandNotFoundException;
import com.inditex.rater.domain.exception.ProductNotFoundException;
import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.ports.output.repository.ProductRepository;
import com.inditex.rater.domain.valueobject.BrandId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {
        TestConfig.class
})
class RateApplicationServiceImplTest {

    private final Integer brandId = 1;
    private final Integer productId = 35455;
    private final LocalDateTime applyDate = LocalDateTime.of(2025, Month.JANUARY, 14, 10, 00, 00);

    private final Brand brand = Brand.builder()
            .brandId(new BrandId(1))
            .name("ZARA")
            .build();

    private final RateProductRequest rateProductRequest =
            new RateProductRequest(brandId, productId, applyDate);

    private RateApplicationServiceImpl rateApplicationService;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void init() {
        this.rateApplicationService = new RateApplicationServiceImpl(
                brandRepository,
                productRepository);
    }

    @Test
    void cannot_rate_product_unexistent_brand() {
        when(this.brandRepository.getByBrandId(new BrandId(brandId))).thenReturn(Optional.empty());
        final BrandNotFoundException brandNotFoundException =
                assertThrows(BrandNotFoundException.class, () -> this.rateApplicationService.rateProduct(rateProductRequest));
        assertEquals("Could not find brand with id: 1", brandNotFoundException.getMessage());
    }

    @Test
    void cannot_rate_product_unexistent_product() {
        when(this.brandRepository.getByBrandId(new BrandId(brandId))).thenReturn(Optional.of(brand));
        final ProductNotFoundException productNotFoundException =
                assertThrows(ProductNotFoundException.class, () -> this.rateApplicationService.rateProduct(rateProductRequest));
        assertEquals("Could not find product with id: 35455", productNotFoundException.getMessage());
    }
}