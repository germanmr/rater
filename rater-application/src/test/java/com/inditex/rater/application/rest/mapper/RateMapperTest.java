package com.inditex.rater.application.rest.mapper;


import com.inditex.rater.application.rest.RaterData;
import com.inditex.rater.application.rest.RaterDtoData;
import com.inditex.rater.domain.dto.RateProductRequest;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.model.RateRequestDto;
import com.inditex.rater.model.RateResponseDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateMapperTest {

    private final RateRequestDto rateRequestDto = RaterDtoData.anyRateRequestDto();
    private final RateResponseDto rateResponseDto = RaterDtoData.anyRateResponseDto();
    private final RateProductRequest rateProductRequest = RaterData.anyRateProductRequest();
    private final PriceList priceList = RaterData.anyPriceList();

    private final RateMapper rateMapper = new RateMapperImpl();

    @Test
    void can_map_rateRequestDto_To_RateRequest() {
        assertEquals(this.rateProductRequest,
                this.rateMapper.rateRequestDtoToRateRequest(rateRequestDto));
    }

    @Test
    void can_map_rateProductResponse_To_RateProductResponseDto() {
        assertEquals(this.rateResponseDto,
                rateMapper.rateProductResponseToRateProductResponseDto(priceList));
    }
}