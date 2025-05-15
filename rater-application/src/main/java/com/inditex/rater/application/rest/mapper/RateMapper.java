package com.inditex.rater.application.rest.mapper;

import com.inditex.rater.domain.dto.RateProductRequest;
import com.inditex.rater.domain.dto.RateProductResponse;
import com.inditex.rater.model.RateRequestDto;
import com.inditex.rater.model.RateResponseDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Service
@Mapper
@MapperConfig(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RateMapper {

    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "applyDate", target = "applyDate", qualifiedByName = "offsetDateTimeToRateDateTime")
    RateProductRequest rateRequestDtoToRateRequest(final RateRequestDto rateRequest);

    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "startDate", target = "startDate", qualifiedByName = "rateDateTimeToOffsetDateTime")
    @Mapping(source = "endDate", target = "endDate", qualifiedByName = "rateDateTimeToOffsetDateTime")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "finalPrice", target = "finalPrice")
    RateResponseDto rateProductResponseToRateProductResponseDto(final RateProductResponse rateProductResponse);

    @Named(value = "offsetDateTimeToRateDateTime")
    default LocalDateTime offsetDateTimeToRateDateTime(final OffsetDateTime offsetDateTime) {
        return offsetDateTime.toLocalDateTime();
    }

    @Named(value = "rateDateTimeToOffsetDateTime")
    default OffsetDateTime rateDateTimeToOffsetDateTime(final LocalDateTime localDateTime) {
        return OffsetDateTime.of(localDateTime, ZoneOffset.UTC);
    }

}
