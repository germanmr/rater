package com.inditex.rater.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RateProductResponse {

    private final Long brandId;
    private final Long productId;
    private final Long priceList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final BigDecimal finalPrice;

    public RateProductResponse(Long brandId, Long productId, Long priceList, LocalDateTime startDate, LocalDateTime endDate, BigDecimal finalPrice) {
        this.brandId = brandId;
        this.productId = productId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalPrice = finalPrice;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getPriceList() {
        return priceList;
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
