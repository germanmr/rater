package com.inditex.rater.application.rest;

import com.inditex.rater.application.rest.config.TestConfig;
import com.inditex.rater.application.rest.mapper.RateMapperImpl;
import com.inditex.rater.domain.RateApplicationServiceImpl;
import com.inditex.rater.domain.entity.RateProductRequest;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.ports.input.service.RateApplicationService;
import com.inditex.rater.model.RateRequestDto;
import com.inditex.rater.model.RateResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        classes = {
                TestConfig.class,
                RateController.class,
                RateMapperImpl.class,
                RateApplicationServiceImpl.class
        })
@ActiveProfiles({"test"})
class RateControllerTest {

    private final RateProductRequest rateProductRequest = RaterData.anyRateProductRequest();

    private final RateRequestDto rateRequestDto = RaterDtoData.anyRateRequestDto();

    private final PriceList priceList = RaterData.anyPriceList();

    @Autowired
    private RateMapperImpl rateMapper;

    @Mock
    private RateApplicationService rateApplicationService;

    private RateController rateController;

    @BeforeEach
    void setUp() {
        this.rateController = new RateController(rateMapper, rateApplicationService);
    }

    @Test
    void can_rate_product() {
        Mockito.when(this.rateApplicationService.rateProduct(this.rateProductRequest)).thenReturn(this.priceList);
        final ResponseEntity<RateResponseDto> rateResponseDtoResponseEntity =
                rateController.rateProduct(this.rateRequestDto);
        assertEquals(RaterDtoData.anyRateResponseDto(), rateResponseDtoResponseEntity.getBody());
    }
}