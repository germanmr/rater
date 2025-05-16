package com.inditex.rater.domain.entity;

import com.inditex.rater.domain.valueobject.BrandId;
import org.immutables.value.Value;

@Value.Immutable(builder = false, copy = false)
public interface Brand {

    @Value.Parameter
    BrandId getBrandId();

    @Value.Parameter
    String getName();

    static Brand of(final BrandId brandId, final String name) {
        return ImmutableBrand.of(brandId,name);
    }


}