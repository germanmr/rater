package com.inditex.rater.dataaccess.product.adapter;

import com.inditex.rater.dataaccess.product.mapper.ProductDataAccessMapper;
import com.inditex.rater.dataaccess.product.repository.ProductJpaRepository;
import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.ports.output.repository.ProductRepository;
import com.inditex.rater.domain.valueobject.ProductId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductDataAccessMapper productDataAccessMapper;

    @Autowired
    public ProductRepositoryImpl(final ProductJpaRepository productJpaRepository,
                                 final ProductDataAccessMapper productDataAccessMapper) {
        this.productJpaRepository = productJpaRepository;
        this.productDataAccessMapper = productDataAccessMapper;
    }

    @Override
    public Optional<Product> getByProductId(final ProductId productId) {
        return this.productDataAccessMapper.optionalProductEntityToOptionalProduct(
                this.productJpaRepository.findById(productId.getValue()));
    }
}
