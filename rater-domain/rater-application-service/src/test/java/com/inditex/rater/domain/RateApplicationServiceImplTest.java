package com.inditex.rater.domain;

import com.inditex.rater.domain.config.TestConfig;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.entity.RateProductRequest;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.exception.BrandNotFoundException;
import com.inditex.rater.domain.exception.PriceListNotFoundException;
import com.inditex.rater.domain.exception.ProductNotFoundException;
import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.ports.output.repository.PriceListRepository;
import com.inditex.rater.domain.ports.output.repository.ProductRepository;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.CurrencyEnum;
import com.inditex.rater.domain.valueobject.Price;
import com.inditex.rater.domain.valueobject.PriceListId;
import com.inditex.rater.domain.valueobject.Priority;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterCurrency;
import com.inditex.rater.domain.valueobject.RaterDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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
    private final Product product = Product.of(ProductId.of(35455L), "PRODUCT 1");

    private final RateProductRequest rateProductRequest =
            RateProductRequest.builder()
                    .brandId(brandId)
                    .productId(productId)
                    .applyDate(applyDate)
                    .build();

    private final LocalDateTime startDate = LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0);
    private final LocalDateTime endDate = LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59);
    private final BigDecimal finalPrice = new BigDecimal("35.50");

    private final PriceList priceList = PriceList.builder()
            .priceListId(PriceListId.of(1L))
            .brandId(BrandId.of(1L))
            .productId(ProductId.of(35455L))
            .startDate(RaterDateTime.of(startDate))
            .priority(Priority.of(1))
            .raterCurrency(RaterCurrency.of(CurrencyEnum.EUR))
            .endDate(RaterDateTime.of(endDate))
            .price(Price.of(finalPrice))
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

    @Test
    void cannot_rate_product_no_price_list() {
        when(this.brandRepository.getByBrandId(BrandId.of(brandId))).thenReturn(Optional.of(brand));
        when(this.productRepository.getByProductId(ProductId.of(productId))).thenReturn(Optional.of(product));
        final PriceListNotFoundException priceListNotFoundException =
                assertThrows(PriceListNotFoundException.class,
                        () -> this.rateApplicationService.rateProduct(rateProductRequest));
        assertEquals("Could not found a price list for brand with id: "
                + rateProductRequest.getBrandId() + " product id: " +
                rateProductRequest.getProductId() + " apply Date: " +
                rateProductRequest.getApplyDate(), priceListNotFoundException.getMessage());
    }

    @Test
    void can_rate_product() {
        when(this.brandRepository.getByBrandId(BrandId.of(brandId))).thenReturn(Optional.of(brand));
        when(this.productRepository.getByProductId(ProductId.of(productId))).thenReturn(Optional.of(product));
        when(this.priceListRepository.rateProductByDate(BrandId.of(brandId), ProductId.of(productId), RaterDateTime.of(applyDate)))
                .thenReturn(Optional.of(priceList));
        assertEquals(priceList, this.rateApplicationService.rateProduct(rateProductRequest));
    }
}