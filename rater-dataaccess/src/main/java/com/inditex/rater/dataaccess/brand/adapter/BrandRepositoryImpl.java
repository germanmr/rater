package com.inditex.rater.dataaccess.brand.adapter;

import com.inditex.rater.dataaccess.brand.mapper.BrandDataAccessMapper;
import com.inditex.rater.dataaccess.brand.repository.BrandJpaRepository;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.valueobject.BrandId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BrandRepositoryImpl implements BrandRepository {

    private final BrandJpaRepository brandJpaRepository;
    private final BrandDataAccessMapper brandDataAccessMapper;

    @Autowired
    public BrandRepositoryImpl(final BrandJpaRepository brandJpaRepository,
                                 final BrandDataAccessMapper brandDataAccessMapper) {
        this.brandJpaRepository = brandJpaRepository;
        this.brandDataAccessMapper = brandDataAccessMapper;
    }

    @Override
    public Optional<Brand> getByBrandId(final BrandId brandId) {
        return this.brandDataAccessMapper.optionalBrandEntityToOptionalBrand(
                this.brandJpaRepository.findById(brandId.getValue()));
    }
}
