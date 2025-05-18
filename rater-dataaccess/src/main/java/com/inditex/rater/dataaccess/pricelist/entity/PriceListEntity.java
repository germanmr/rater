package com.inditex.rater.dataaccess.pricelist.entity;

import com.inditex.rater.dataaccess.brand.entity.BrandEntity;
import com.inditex.rater.dataaccess.product.entity.ProductEntity;
import com.inditex.rater.domain.valueobject.CurrencyEnum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Table(name = "prices")
@Entity
public class PriceListEntity {
    @Id
    private Long id;
    private Integer priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    private BigDecimal price;

    public LocalDateTime startDate;

    public LocalDateTime endDate;

    public PriceListEntity() {
    }

    public PriceListEntity(Long id,
                           Integer priority,
                           BrandEntity brandEntity,
                           ProductEntity productEntity,
                           CurrencyEnum currency,
                           BigDecimal price,
                           LocalDateTime startDate,
                           LocalDateTime endDate) {
        this.id = id;
        this.priority = priority;
        this.brandEntity = brandEntity;
        this.productEntity = productEntity;
        this.currency = currency;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PriceListEntity that = (PriceListEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(priority, that.priority)
                && Objects.equals(brandEntity, that.brandEntity) && Objects.equals(productEntity, that.productEntity)
                && currency == that.currency && Objects.equals(price, that.price) &&
                Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priority, brandEntity, productEntity, currency, price, startDate, endDate);
    }
}
