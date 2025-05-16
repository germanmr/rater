package com.inditex.rater.domain.valueobject;

import org.immutables.value.Value;


@Value.Immutable(builder = false, copy = false)
public interface RaterCurrency {

    @Value.Parameter
    CurrencyEnum getValue();

    static RaterCurrency of(final CurrencyEnum value) {
        return ImmutableRaterCurrency.of(value);
    }

}