package com.inditex.rater.application.exception.handler;

import com.inditex.rater.domain.exception.BrandNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler =
            new GlobalExceptionHandler();

    @Test
    void can_handle_domain_exception_and_return_error() {
        assertEquals(ErrorDTO.builder()
                        .code("Not Found")
                        .message("could not find brand with id: " + 1L)
                        .build(),
                globalExceptionHandler.handleException(
                        new BrandNotFoundException("could not find brand with id: " + 1L)));
    }

    @Test
    void can_handle_exception_and_return_error() {
        assertEquals(ErrorDTO.builder()
                        .code("Internal Server Error")
                        .message("Unexpected error!")
                        .build(),
                globalExceptionHandler.handleException(
                        new Exception("Some error")));
    }

}