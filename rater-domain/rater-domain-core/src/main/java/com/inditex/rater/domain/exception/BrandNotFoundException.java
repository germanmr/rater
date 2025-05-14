package com.inditex.rater.domain.exception;

public class BrandNotFoundException extends DomainException{
    public BrandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrandNotFoundException(String message) {
        super(message);
    }
}
