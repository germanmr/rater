package com.inditex.rater.domain.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

public final class RateProductRequest {

    @NotNull
    private final Long brandId;
    @NotNull
    private final Long productId;
    @NotNull
    private final LocalDateTime applyDate;

    public RateProductRequest(final Long brandId,final Long productId,final LocalDateTime applyDate) {
        this.brandId = brandId;
        this.productId = productId;
        this.applyDate = applyDate;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getProductId() {
        return productId;
    }

    public LocalDateTime getApplyDate() {
        return applyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RateProductRequest that = (RateProductRequest) o;
        return Objects.equals(brandId, that.brandId) && Objects.equals(productId, that.productId) && Objects.equals(applyDate, that.applyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, productId, applyDate);
    }
}
