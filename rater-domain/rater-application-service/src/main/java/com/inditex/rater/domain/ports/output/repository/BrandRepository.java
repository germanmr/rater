package com.inditex.rater.domain.ports.output.repository;

import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.valueobject.BrandId;

import java.util.Optional;

public interface BrandRepository {

    Optional<Brand> getByBrandId(final BrandId brand);
}
