package com.inditex.rater.dataaccess.product.adapter;

import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.valueobject.BrandId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BrandRepositoryImpl implements BrandRepository {
    @Override
    public Brand save(Brand brand) {
        return null;
    }

    @Override
    public Optional<Brand> getByBrandId(BrandId brand) {
        return Optional.empty();
    }
}
