package com.inditex.rater.application.rest;

import com.inditex.rater.application.exception.handler.GlobalExceptionHandler;
import com.inditex.rater.api.RateApi;
import com.inditex.rater.application.rest.mapper.RateMapper;
import com.inditex.rater.domain.ports.input.service.RateApplicationService;
import com.inditex.rater.model.RateRequestDto;
import com.inditex.rater.model.RateResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController extends GlobalExceptionHandler implements RateApi {

    private static final Logger log = LoggerFactory.getLogger(RateController.class);

    private final RateMapper rateMapper;
    private final RateApplicationService rateApplicationService;

    public RateController(final RateMapper rateMapper,
                          final RateApplicationService rateApplicationService) {
        this.rateMapper = rateMapper;
        this.rateApplicationService = rateApplicationService;
    }

    @Override
    public ResponseEntity<RateResponseDto> rateProduct(@RequestBody RateRequestDto rateRequestDto) {
        log.info("Rating product: {} for brand: {} ", rateRequestDto.getProductId(), rateRequestDto.getBrandId());
        return new ResponseEntity<RateResponseDto>(
                this.rateMapper.priceListToRateProductResponseDto(
                this.rateApplicationService.rateProduct(
                        this.rateMapper.rateRequestDtoToRateRequest(rateRequestDto)))
                ,HttpStatus.OK);
    }
}
