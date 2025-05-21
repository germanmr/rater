package com.inditex.rater.application.exception.handler;

import lombok.Builder;

@Builder
public record ErrorDTO(String code, String message) {
}
