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

import java.util.Optional;


@Service
@Mapper
public interface PriceListDataAccessMapper {

    default Optional<PriceList> priceListEntityToPriceList(final Optional<PriceListEntity> priceListEntity) {
        return priceListEntity.map(ple -> PriceList.builder()
                .priceListId(PriceListId.of(ple.getId()))
                .brandId(BrandId.of(ple.getBrandEntity().getId()))
                .productId(ProductId.of(ple.getProductEntity().getId()))
                .price(Price.of(ple.getPrice()))
                .startDate(RaterDateTime.of(ple.getStartDate()))
                .endDate(RaterDateTime.of(ple.getEndDate()))
                .priority(Priority.of(ple.getPriority()))
                .raterCurrency(RaterCurrency.of(ple.getCurrency()))
                .build());
    }
}

