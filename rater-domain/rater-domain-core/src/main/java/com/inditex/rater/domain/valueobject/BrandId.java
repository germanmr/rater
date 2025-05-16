package com.inditex.rater.domain.valueobject;

import org.immutables.value.Value;

@Value.Immutable(builder = false, copy = false)
public interface BrandId {

    @Value.Parameter
    Long getValue();

    static BrandId of(final Long value) {
        return ImmutableBrandId.of(value);
    }
}