package com.inditex.rater.domain.exception;

import com.inditex.rater.domain.exception.base.DomainException;

public class PriceListNotFoundException extends DomainException {
    public PriceListNotFoundException(String message) {
        super(message);
    }
}
