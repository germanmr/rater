package com.inditex.rater.domain.valueobject;

import org.immutables.value.Value;

@Value.Immutable(builder = false, copy = false)
public interface ProductId {

    @Value.Parameter
    Long getValue();

    static ProductId of(final Long value) {
        return ImmutableProductId.of(value);
    }

}