package com.inditex.rater.dataaccess.brand.mapper;

import com.inditex.rater.dataaccess.brand.entity.BrandEntity;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.valueobject.BrandId;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Mapper
public interface BrandDataAccessMapper {

    default Optional<Brand> optionalBrandEntityToOptionalBrand(final Optional<BrandEntity> brandEntity) {
        return brandEntity.map(be -> Brand.of(BrandId.of(be.getId()), be.getName()));
    }
}
