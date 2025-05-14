package com.inditex.rater.domain.valueobject;

import com.inditex.rater.domain.base.BaseId;

public class RaterCurrency extends BaseId<CurrencyEnum> {

    public RaterCurrency(final CurrencyEnum value) {
        super(value);
    }
}