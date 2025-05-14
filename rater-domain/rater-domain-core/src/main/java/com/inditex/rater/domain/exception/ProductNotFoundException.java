package com.inditex.rater.domain.exception;

import com.inditex.rater.domain.exception.base.DomainException;

public class ProductNotFoundException extends DomainException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
