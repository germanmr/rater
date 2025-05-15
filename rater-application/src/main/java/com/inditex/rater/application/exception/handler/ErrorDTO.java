package com.inditex.rater.application.exception.handler;

import java.util.Objects;

public final class ErrorDTO {
    private final String code;
    private final String message;

    private ErrorDTO(Builder builder) {
        code = builder.code;
        message = builder.message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDTO errorDTO = (ErrorDTO) o;
        return Objects.equals(code, errorDTO.code) && Objects.equals(message, errorDTO.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static final class Builder {
        private String code;
        private String message;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder code(String val) {
            code = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public ErrorDTO build() {
            return new ErrorDTO(this);
        }
    }
}
