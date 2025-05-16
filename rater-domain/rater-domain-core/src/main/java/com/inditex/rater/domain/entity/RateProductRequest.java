package com.inditex.rater.domain.entity;

import org.immutables.value.Value;

import java.time.LocalDateTime;


@Value.Immutable
public abstract class RateProductRequest {

    @Value.Parameter
    public abstract Long getBrandId();

    @Value.Parameter
    public abstract Long getProductId();

    @Value.Parameter
    public abstract LocalDateTime getApplyDate();

    public static Builder builder() {
        return ImmutableRateProductRequest.builder();
    }

    public interface Builder {

        Builder brandId(Long brandId);

        Builder productId(Long productId);

        Builder applyDate(LocalDateTime applyDate);

        RateProductRequest build();
    }


}
