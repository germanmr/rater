package com.inditex.rater.dataaccess.brand.adapter;

import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.ports.output.repository.PriceListRepository;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterDateTime;
import org.springframework.stereotype.Component;

@Component
public class PriceListRepositoryImpl implements PriceListRepository {

    @Override
    public PriceList rateProductByDate(BrandId brandId, ProductId productId, RaterDateTime applyDate) {
        return null;
    }
}
