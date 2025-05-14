package com.inditex.rater.domain.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class RateProductRequest {

    @NotNull
    private final Integer brandId;
    @NotNull
    private final Integer productId;
    @NotNull
    private final LocalDateTime applyDate;

    public RateProductRequest(Integer brandId, Integer productId, LocalDateTime applyDate) {
        this.brandId = brandId;
        this.productId = productId;
        this.applyDate = applyDate;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    public LocalDateTime getApplyDate() {
        return applyDate;
    }
}
