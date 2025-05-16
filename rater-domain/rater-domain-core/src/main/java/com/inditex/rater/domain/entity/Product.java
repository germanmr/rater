package com.inditex.rater.domain.entity;

import com.inditex.rater.domain.valueobject.ProductId;
import org.immutables.value.Value;


@Value.Immutable
public interface Product {

    @Value.Parameter
    ProductId getProductId();

    @Value.Parameter
    String getName();

    static Product of(final ProductId productId, final String name) {
        return ImmutableProduct.of(productId,name);
    }

}