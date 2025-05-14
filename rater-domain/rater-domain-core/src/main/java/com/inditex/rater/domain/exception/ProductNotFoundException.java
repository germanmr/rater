package com.inditex.rater.domain.exception;

public class ProductNotFoundException extends DomainException{
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
