package com.inditex.rater.dataaccess.pricelist.adapter;

import com.inditex.rater.dataaccess.pricelist.mapper.PriceListDataAccessMapper;
import com.inditex.rater.dataaccess.pricelist.repository.PriceListJpaRepository;
import com.inditex.rater.domain.entity.PriceList;
import com.inditex.rater.domain.ports.output.repository.PriceListRepository;
import com.inditex.rater.domain.valueobject.BrandId;
import com.inditex.rater.domain.valueobject.ProductId;
import com.inditex.rater.domain.valueobject.RaterDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PriceListRepositoryImpl implements PriceListRepository {

    /**
     * Limit to 1 result for the highest priority
     */
    private final PageRequest pageRequest = PageRequest.of(0, 1);

    private final PriceListDataAccessMapper priceListDataAccessMapper;
    private final PriceListJpaRepository priceListJpaRepository;

    @Autowired
    public PriceListRepositoryImpl(PriceListDataAccessMapper priceListDataAccessMapper, PriceListJpaRepository priceListJpaRepository) {
        this.priceListDataAccessMapper = priceListDataAccessMapper;
        this.priceListJpaRepository = priceListJpaRepository;
    }

    @Override
    public Optional<PriceList> rateProductByDate(final BrandId brandId,
                                                 final ProductId productId,
                                                 final RaterDateTime applyDate) {
        return this.priceListDataAccessMapper.priceListEntityToPriceList(
                this.priceListJpaRepository.findByBrandAndProductAndApplyDate(
                                brandId.getValue(),
                                productId.getValue(),
                                applyDate.getValue(),
                                pageRequest)
                        .stream()
                        .findFirst());
    }
}
