package com.inditex.rater.domain;

import com.inditex.rater.domain.config.TestConfig;
import com.inditex.rater.domain.entity.RateProductRequest;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.exception.BrandNotFoundException;
import com.inditex.rater.domain.exception.ProductNotFoundException;
import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.ports.output.repository.PriceListRepository;
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

    private final Long brandId = 1L;
    private final Long productId = 35455L;
    private final LocalDateTime applyDate = LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0);

    private final Brand brand = Brand.of(BrandId.of(1L), "ZARA");

    private final RateProductRequest rateProductRequest =
            RateProductRequest.builder()
                    .brandId(brandId)
                    .productId(productId)
                    .applyDate(applyDate)
                    .build();

    private RateApplicationServiceImpl rateApplicationService;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceListRepository priceListRepository;

    @BeforeEach
    void init() {
        this.rateApplicationService = new RateApplicationServiceImpl(
                brandRepository,
                productRepository,
                priceListRepository);
    }

    @Test
    void cannot_rate_product_unexistent_brand() {
        when(this.brandRepository.getByBrandId(BrandId.of(brandId))).thenReturn(Optional.empty());
        final BrandNotFoundException brandNotFoundException =
                assertThrows(BrandNotFoundException.class, () -> this.rateApplicationService.rateProduct(rateProductRequest));
        assertEquals("Could not find brand with id: 1", brandNotFoundException.getMessage());
    }

    @Test
    void cannot_rate_product_unexistent_product() {
        when(this.brandRepository.getByBrandId(BrandId.of(brandId))).thenReturn(Optional.of(brand));
        final ProductNotFoundException productNotFoundException =
                assertThrows(ProductNotFoundException.class, () -> this.rateApplicationService.rateProduct(rateProductRequest));
        assertEquals("Could not find product with id: 35455", productNotFoundException.getMessage());
    }
}