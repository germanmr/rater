package com.inditex.rater.domain.entity;

import com.inditex.rater.domain.base.AggregateRoot;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.RaterCurrency;
import com.inditex.rater.domain.valueobject.RaterDateTime;
import com.inditex.rater.domain.valueobject.Price;
import com.inditex.rater.domain.valueobject.PriceListId;
import com.inditex.rater.domain.valueobject.Priority;
import com.inditex.rater.domain.valueobject.ProductId;

import java.util.Objects;


public final class PriceList extends AggregateRoot<PriceListId> {

    private final BrandId brandId;
    private final ProductId productId;
    private final RaterDateTime startDate;
    private final RaterDateTime endDate;
    private final Priority priority;
    private final Price price;
    private final RaterCurrency raterCurrency;

    public BrandId getBrandId() {
        return brandId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public RaterDateTime getStartDate() {
        return startDate;
    }

    public RaterDateTime getEndDate() {
        return endDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public Price getPrice() {
        return price;
    }

    public RaterCurrency getRaterCurrency() {
        return raterCurrency;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PriceList priceList = (PriceList) o;
        return Objects.equals(brandId, priceList.brandId) && Objects.equals(productId, priceList.productId) && Objects.equals(startDate, priceList.startDate) && Objects.equals(endDate, priceList.endDate) && Objects.equals(priority, priceList.priority) && Objects.equals(price, priceList.price) && Objects.equals(raterCurrency, priceList.raterCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brandId, productId, startDate, endDate, priority, price, raterCurrency);
    }

    @Override
    public String toString() {
        return "PriceList{" +
                "brandId=" + brandId +
                ", productId=" + productId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priority=" + priority +
                ", price=" + price +
                ", raterCurrency=" + raterCurrency +
                '}';
    }

    private PriceList(Builder builder) {
        super.setId(builder.id);
        brandId = builder.brandId;
        productId = builder.productId;
        startDate = builder.startDate;
        endDate = builder.endDate;
        priority = builder.priority;
        price = builder.price;
        raterCurrency = builder.raterCurrency;
    }

    public static final class Builder {
        private PriceListId id;
        private BrandId brandId;
        private ProductId productId;
        private RaterDateTime startDate;
        private RaterDateTime endDate;
        private Priority priority;
        private Price price;
        private RaterCurrency raterCurrency;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(PriceListId val) {
            id = val;
            return this;
        }

        public Builder brandId(BrandId val) {
            brandId = val;
            return this;
        }

        public Builder productId(ProductId val) {
            productId = val;
            return this;
        }

        public Builder startDate(RaterDateTime val) {
            startDate = val;
            return this;
        }

        public Builder endDate(RaterDateTime val) {
            endDate = val;
            return this;
        }

        public Builder priority(Priority val) {
            priority = val;
            return this;
        }

        public Builder price(Price val) {
            price = val;
            return this;
        }

        public Builder raterCurrency(RaterCurrency val) {
            raterCurrency = val;
            return this;
        }

        public PriceList build() {
            return new PriceList(this);
        }
    }
}