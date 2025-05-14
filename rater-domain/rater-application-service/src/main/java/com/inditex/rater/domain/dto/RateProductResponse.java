package com.inditex.rater.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RateProductResponse {

    private final Integer brandId;
    private final Integer productId;
    private final BigDecimal price;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final BigDecimal finalPrice;

    public RateProductResponse(Integer brandId, Integer productId, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate, BigDecimal finalPrice) {
        this.brandId = brandId;
        this.productId = productId;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }
}
