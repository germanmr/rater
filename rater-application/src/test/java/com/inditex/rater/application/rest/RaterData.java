package com.inditex.rater.application.rest;

import com.inditex.rater.domain.dto.RateProductRequest;
import com.inditex.rater.domain.dto.RateProductResponse;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.Price;
import com.inditex.rater.domain.valueobject.PriceListId;
import com.inditex.rater.domain.valueobject.ProductId;
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
        return new RateProductRequest(
                BRAND_ID,
                PRODUCT_ID,
                APPLY_DATE);
    }

    static RateProductResponse anyRateProductResponse() {
        return new RateProductResponse(
                BRAND_ID,
                PRODUCT_ID,
                PRICE_LIST,
                START_DATE,
                END_DATE,
                FINAL_PRICE);
    }

    static PriceList anyPriceList() {
        return PriceList.Builder.builder()
                .brandId(new BrandId(BRAND_ID))
                .productId(new ProductId(PRODUCT_ID))
                .startDate(new RaterDateTime(START_DATE))
                .endDate(new RaterDateTime(END_DATE))
                .id(new PriceListId(PRICE_LIST))
                .price(new Price(FINAL_PRICE))
                .build();
    }
}
