package com.inditex.rater.domain.entity;

import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.Price;
import com.inditex.rater.domain.valueobject.RaterCurrency;
import com.inditex.rater.domain.valueobject.RaterDateTime;
import com.inditex.rater.domain.valueobject.PriceListId;
import com.inditex.rater.domain.valueobject.Priority;
import com.inditex.rater.domain.valueobject.ProductId;
import org.immutables.value.Value;

@Value.Immutable
public abstract class PriceList {

    @Value.Parameter
    public abstract PriceListId getPriceListId();

    @Value.Parameter
    public abstract BrandId getBrandId();

    @Value.Parameter
    public abstract ProductId getProductId();

    @Value.Parameter
    public abstract RaterDateTime getStartDate();

    @Value.Parameter
    public abstract RaterDateTime getEndDate();

    @Value.Parameter
    public abstract Priority getPriority();

    @Value.Parameter
    public abstract Price getPrice();

    @Value.Parameter
    public abstract RaterCurrency getRaterCurrency();

    public static Builder builder() {
        return ImmutablePriceList.builder();
    }

    public interface Builder {

        Builder priceListId(PriceListId priceListId);

        Builder brandId(BrandId brand);

        Builder productId(ProductId productId);

        Builder startDate(RaterDateTime dateTime);

        Builder endDate(RaterDateTime raterDateTime);

        Builder priority(Priority priority);

        Builder price(Price price);

        Builder raterCurrency(RaterCurrency raterCurrency);

        PriceList build();
    }


}