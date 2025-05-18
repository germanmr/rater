package com.inditex.rater.dataaccess.pricelist.mapper;

import com.inditex.rater.dataaccess.pricelist.entity.PriceListEntity;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.Price;
import com.inditex.rater.domain.valueobject.PriceListId;
import com.inditex.rater.domain.valueobject.Priority;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterCurrency;
import com.inditex.rater.domain.valueobject.RaterDateTime;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;


@Service
@Mapper
public interface PriceListDataAccessMapper {

    default PriceList priceListEntityToPriceList(PriceListEntity priceListEntity) {
        return PriceList.builder()
                .priceListId(PriceListId.of(priceListEntity.getId()))
                .brandId(BrandId.of(priceListEntity.getBrandEntity().getId()))
                .productId(ProductId.of(priceListEntity.getProductEntity().getId()))
                .price(Price.of(priceListEntity.getPrice()))
                .startDate(RaterDateTime.of(priceListEntity.getStartDate()))
                .endDate(RaterDateTime.of(priceListEntity.getEndDate()))
                .priority(Priority.of(priceListEntity.getPriority()))
                .raterCurrency(RaterCurrency.of(priceListEntity.getCurrency()))
                .build();
    }
}

