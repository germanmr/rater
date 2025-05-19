package com.inditex.rater.domain.ports.output.repository;

import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterDateTime;

import java.util.Optional;

public interface PriceListRepository {

     Optional<PriceList> rateProductByDate(final BrandId brandId, final ProductId productId, final RaterDateTime applyDate );

}
