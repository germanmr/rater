package com.inditex.rater.dataaccess.product.mapper;

import com.inditex.rater.dataaccess.product.entity.ProductEntity;
import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.valueobject.ProductId;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Mapper
public interface ProductDataAccessMapper {

    default Optional<Product> optionalProductEntityToOptionalProduct(final Optional<ProductEntity> productEntity) {
        return productEntity.map(pe -> Product.of(ProductId.of(pe.getId()), pe.getName()));
    }
}
