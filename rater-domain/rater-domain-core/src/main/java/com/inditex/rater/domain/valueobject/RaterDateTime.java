package com.inditex.rater.domain.valueobject;

import org.immutables.value.Value;

import java.time.LocalDateTime;

@Value.Immutable(builder = false, copy = false)
public interface RaterDateTime {

    @Value.Parameter
    LocalDateTime getValue();

    static RaterDateTime of(final LocalDateTime value) {
        return ImmutableRaterDateTime.of(value);
    }

}