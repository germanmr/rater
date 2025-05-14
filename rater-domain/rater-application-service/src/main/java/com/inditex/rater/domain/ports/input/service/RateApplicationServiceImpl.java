package com.inditex.rater.domain.ports.input.service;

import com.inditex.rater.domain.dto.RateProductRequest;
import com.inditex.rater.domain.dto.RateProductResponse;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.exception.BrandNotFoundException;
import com.inditex.rater.domain.exception.ProductNotFoundException;
import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.ports.output.repository.ProductRepository;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.ProductId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

@Validated
@Service
public class RateApplicationServiceImpl implements RateApplicationService {

    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;

    @Autowired
    public RateApplicationServiceImpl(final BrandRepository brandRepository,
                                      final ProductRepository productRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }

    @Override
    public RateProductResponse rateProduct(@Valid final RateProductRequest rateRequest) {
        checkBrand(rateRequest.getBrandId());
        checkProduct(rateRequest.getProductId());
        return null;
    }

    private void checkBrand(final Integer brandId) {
        final Optional<Brand> optional = brandRepository.getByBrandId(new BrandId(brandId));
        if (optional.isEmpty()) {
            throw new BrandNotFoundException("Could not brand with id: " + brandId);
        }
    }

    private void checkProduct(final Integer productId) {
        final Optional<Product> optional = productRepository.getByProductId(new ProductId(productId));
        if (optional.isEmpty()) {
            throw new ProductNotFoundException("Could not product with id: " + productId);
        }
    }
}
