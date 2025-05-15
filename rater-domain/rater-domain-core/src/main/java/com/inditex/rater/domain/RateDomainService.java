package com.inditex.rater.domain;

import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterDateTime;

public interface RateDomainService {

    PriceList rateProduct(final BrandId brandId, final ProductId productId, final RaterDateTime applyTime);
}
