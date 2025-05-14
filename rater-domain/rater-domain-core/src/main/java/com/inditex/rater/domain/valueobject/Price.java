package com.inditex.rater.domain.valueobject;

import com.inditex.rater.domain.base.BaseId;

import java.math.BigDecimal;

public final class Price extends BaseId<BigDecimal> {

    public Price(BigDecimal value) {
        super(value);
    }
}