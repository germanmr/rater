package com.inditex.rater.domain.valueobject;

import org.immutables.value.Value;

import java.math.BigDecimal;

@Value.Immutable(builder = false, copy = false)
public interface Price {

    @Value.Parameter
    BigDecimal getValue();

    static Price of(final BigDecimal value) {
        return ImmutablePrice.of(value);
    }
}