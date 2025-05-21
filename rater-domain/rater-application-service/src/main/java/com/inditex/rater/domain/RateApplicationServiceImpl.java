package com.inditex.rater.domain;

import com.inditex.rater.domain.entity.RateProductRequest;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.exception.BrandNotFoundException;
import com.inditex.rater.domain.exception.ProductNotFoundException;
import com.inditex.rater.domain.exception.PriceListNotFoundException;
import com.inditex.rater.domain.ports.input.service.RateApplicationService;
import com.inditex.rater.domain.ports.output.repository.BrandRepository;
import com.inditex.rater.domain.ports.output.repository.PriceListRepository;
import com.inditex.rater.domain.ports.output.repository.ProductRepository;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Validated
@Service
public class RateApplicationServiceImpl implements RateApplicationService {

    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    private final PriceListRepository priceListRepository;

    @Autowired
    public RateApplicationServiceImpl(final BrandRepository brandRepository,
                                      final ProductRepository productRepository,
                                      final PriceListRepository priceListRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
        this.priceListRepository = priceListRepository;
    }

    @Override
    public PriceList rateProduct(final RateProductRequest rateProductRequest) {
        checkBrand(rateProductRequest.getBrandId());
        checkProduct(rateProductRequest.getProductId());
        return this.priceListRepository.rateProductByDate(
                        BrandId.of(rateProductRequest.getBrandId()),
                        ProductId.of(rateProductRequest.getProductId()),
                        RaterDateTime.of(rateProductRequest.getApplyDate()))
                .orElseThrow(() -> new PriceListNotFoundException("Could not found a price list for brand with id: "
                        + rateProductRequest.getBrandId() + " product id: " +
                        rateProductRequest.getProductId() + " apply Date: " +
                        rateProductRequest.getApplyDate()));

    }

    private void checkBrand(final Long brandId) {
        final Optional<Brand> optional = this.brandRepository.getByBrandId(BrandId.of(brandId));
        if (optional.isEmpty()) {
            throw new BrandNotFoundException("Could not find brand with id: " + brandId);
        }
    }

    private void checkProduct(final Long productId) {
        final Optional<Product> optional = this.productRepository.getByProductId(ProductId.of(productId));
        if (optional.isEmpty()) {
            throw new ProductNotFoundException("Could not find product with id: " + productId);
        }
    }
}
