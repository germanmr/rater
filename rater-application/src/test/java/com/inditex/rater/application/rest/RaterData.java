package com.inditex.rater.application.rest;

import com.inditex.rater.domain.entity.RateProductRequest;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.CurrencyEnum;
import com.inditex.rater.domain.valueobject.Price;
import com.inditex.rater.domain.valueobject.PriceListId;
import com.inditex.rater.domain.valueobject.Priority;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterCurrency;
import com.inditex.rater.domain.valueobject.RaterDateTime;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public interface RaterData {

    Long BRAND_ID = 1L;
    Long PRODUCT_ID = 35455L;
    Long PRICE_LIST = 1L;
    LocalDateTime START_DATE = LocalDateTime.of(2020, Month.JUNE, 14, 0, 0, 0);
    LocalDateTime END_DATE = LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59);

    LocalDateTime APPLY_DATE = LocalDateTime.of(2020, Month.JUNE, 14, 10, 0, 0);

    BigDecimal FINAL_PRICE = new BigDecimal("35.50");

    static RateProductRequest anyRateProductRequest() {
        return RateProductRequest.builder()
                .brandId(BRAND_ID)
                .productId(PRODUCT_ID)
                .applyDate(APPLY_DATE)
                .build();
    }

    static PriceList anyPriceList() {
        return PriceList.builder()
                .priceListId(PriceListId.of(PRICE_LIST))
                .brandId(BrandId.of(BRAND_ID))
                .productId(ProductId.of(PRODUCT_ID))
                .startDate(RaterDateTime.of(START_DATE))
                .priority(Priority.of(1))
                .raterCurrency(RaterCurrency.of(CurrencyEnum.EUR))
                .endDate(RaterDateTime.of(END_DATE))
                .price(Price.of(FINAL_PRICE))
                .build();
    }
}
