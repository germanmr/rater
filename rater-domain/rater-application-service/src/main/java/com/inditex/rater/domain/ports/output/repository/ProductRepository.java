package com.inditex.rater.domain.ports.output.repository;

import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.valueobject.ProductId;

import java.util.Optional;

public interface ProductRepository {

    Product save(final Product product);

    Optional<Product> getByProductId(final ProductId productId);
}
