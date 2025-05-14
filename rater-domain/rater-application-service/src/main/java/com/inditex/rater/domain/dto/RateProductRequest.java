package com.inditex.rater.domain.dto;

import java.time.LocalDateTime;

public class RateProductRequest {

    private final Integer brandId;
    private final Integer productId;
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
