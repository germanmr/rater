package com.inditex.rater.domain.valueobject;

import org.immutables.value.Value;


@Value.Immutable(builder = false, copy = false)
public interface PriceListId {

    @Value.Parameter
    Long getValue();

    static PriceListId of(final Long value) {
        return ImmutablePriceListId.of(value);
    }

}