package com.inditex.rater.domain;

import com.inditex.rater.domain.dto.RateProductRequest;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.exception.BrandNotFoundException;
import com.inditex.rater.domain.exception.ProductNotFoundException;
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

import javax.validation.Valid;
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
    public PriceList rateProduct(@Valid final RateProductRequest rateProductRequest) {
        checkBrand(rateProductRequest.getBrandId());
        checkProduct(rateProductRequest.getProductId());
        return priceListRepository.rateProductByDate(
                new BrandId(rateProductRequest.getBrandId()),
                new ProductId(rateProductRequest.getProductId()),
                new RaterDateTime(rateProductRequest.getApplyDate()));
    }

    private void checkBrand(final Long brandId) {
        final Optional<Brand> optional = brandRepository.getByBrandId(new BrandId(brandId));
        if (optional.isEmpty()) {
            throw new BrandNotFoundException("Could not find brand with id: " + brandId);
        }
    }

    private void checkProduct(final Long productId) {
        final Optional<Product> optional = productRepository.getByProductId(new ProductId(productId));
        if (optional.isEmpty()) {
            throw new ProductNotFoundException("Could not find product with id: " + productId);
        }
    }
}
