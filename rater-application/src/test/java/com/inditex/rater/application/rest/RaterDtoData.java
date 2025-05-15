package com.inditex.rater.application.rest;

import com.inditex.rater.model.RateRequestDto;
import com.inditex.rater.model.RateResponseDto;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public interface RaterDtoData {

    Long BRAND_ID = 1L;
    Long PRODUCT_ID = 35455L;
    OffsetDateTime APPLY_DATE = OffsetDateTime.of(2020, 6, 14, 10, 0, 0, 0, ZoneOffset.UTC);

    OffsetDateTime START_DATE_OFFSET = OffsetDateTime.of(2020, 6, 14, 0, 0, 0, 0, ZoneOffset.UTC);
    OffsetDateTime END_DATE_OFFSET = OffsetDateTime.of(2020, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC);
    Long PRICE_LIST = 1L;
    Float FINAL_PRICE = 35.50F;

    static RateRequestDto anyRateRequestDto() {
        return new RateRequestDto(
                BRAND_ID,
                PRODUCT_ID,
                APPLY_DATE);
    }

    static RateResponseDto anyRateResponseDto() {
        return new RateResponseDto(
                BRAND_ID,
                PRODUCT_ID,
                START_DATE_OFFSET,
                END_DATE_OFFSET,
                PRICE_LIST,
                FINAL_PRICE);
    }
}
