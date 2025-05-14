package com.inditex.rater.domain.valueobject;

import com.inditex.rater.domain.base.BaseId;

import java.time.LocalDateTime;

public class RaterDateTime extends BaseId<LocalDateTime> {

    public RaterDateTime(final LocalDateTime value) {
        super(value);
    }
}