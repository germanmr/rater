package com.inditex.rater.domain.exception;

import com.inditex.rater.domain.exception.base.DomainException;

public class BrandNotFoundException extends DomainException {
    public BrandNotFoundException(String message) {
        super(message);
    }
}
