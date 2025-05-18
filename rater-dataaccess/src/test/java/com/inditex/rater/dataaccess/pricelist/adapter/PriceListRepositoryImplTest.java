package com.inditex.rater.dataaccess.pricelist.adapter;

import com.inditex.rater.dataaccess.brand.entity.BrandEntity;
import com.inditex.rater.dataaccess.config.DataAccessTestConfiguration;
import com.inditex.rater.dataaccess.pricelist.entity.PriceListEntity;
import com.inditex.rater.dataaccess.pricelist.mapper.PriceListDataAccessMapper;
import com.inditex.rater.dataaccess.pricelist.mapper.PriceListDataAccessMapperImpl;
import com.inditex.rater.dataaccess.pricelist.repository.PriceListJpaRepository;
import com.inditex.rater.dataaccess.product.entity.ProductEntity;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.CurrencyEnum;
import com.inditex.rater.domain.valueobject.Price;
import com.inditex.rater.domain.valueobject.PriceListId;
import com.inditex.rater.domain.valueobject.Priority;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterCurrency;
import com.inditex.rater.domain.valueobject.RaterDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = {
        DataAccessTestConfiguration.class,
        PriceListDataAccessMapperImpl.class})
class PriceListRepositoryImplTest {

    private final Long priceListId = 1L;
    private final Long brandId = 1L;
    private final Long productId = 35455L;
    private final LocalDateTime startDate = LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0);
    private final LocalDateTime endDate = LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59);
    private final LocalDateTime applyDate = LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0);
    private final BigDecimal price = new BigDecimal("35.50");
    private final Integer priority = 1;

    private final CurrencyEnum currencyEnum = CurrencyEnum.EUR;

    private final PriceList priceList = PriceList.builder()
            .priceListId(PriceListId.of(priceListId))
            .brandId(BrandId.of(brandId))
            .productId(ProductId.of(productId))
            .startDate(RaterDateTime.of(startDate))
            .endDate(RaterDateTime.of(endDate))
            .priority(Priority.of(priority))
            .price(Price.of(price))
            .raterCurrency(RaterCurrency.of(CurrencyEnum.EUR))
            .build();

    private final PriceListEntity priceListEntity = new PriceListEntity(
            priceListId,
            priority,
            new BrandEntity(brandId,"ZARA"),
            new ProductEntity(productId,"Product1"),
            currencyEnum,
            price,
            startDate,
            endDate);

    @Autowired
    private PriceListJpaRepository priceListJpaRepository;
    @Autowired
    private PriceListDataAccessMapper priceListDataAccessMapper;

    private PriceListRepositoryImpl priceListRepository;

    @BeforeAll
    void setUp() {
        this.priceListRepository = new PriceListRepositoryImpl(
                priceListDataAccessMapper, priceListJpaRepository);
    }

    @Test
    void can_get_by_id() {
        when(priceListJpaRepository.findByBrandAndProductAndApplyDate(brandId,productId,applyDate)).thenReturn(priceListEntity);
        assertEquals(priceList,
                priceListRepository.rateProductByDate(BrandId.of(brandId), ProductId.of(productId), RaterDateTime.of(applyDate)));
    }

}