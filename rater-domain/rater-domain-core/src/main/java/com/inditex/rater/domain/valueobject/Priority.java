package com.inditex.rater.domain.valueobject;

import org.immutables.value.Value;


@Value.Immutable(builder = false, copy = false)
public interface Priority {

    @Value.Parameter
    Integer geValue();

    static Priority of(final Integer value) {
        return ImmutablePriority.of(value);
    }

}