package com.inditex.rater.dataaccess.pricelist.adapter;

import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.ports.output.repository.ProductRepository;
import com.inditex.rater.domain.valueobject.ProductId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> getByProductId(ProductId productId) {
        return Optional.empty();
    }
}
