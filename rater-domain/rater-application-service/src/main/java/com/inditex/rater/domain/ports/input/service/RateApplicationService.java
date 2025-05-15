package com.inditex.rater.domain.ports.input.service;

import com.inditex.rater.domain.dto.RateProductRequest;
import com.inditex.rater.domain.entity.PriceList;

public interface RateApplicationService {

    PriceList rateProduct(final RateProductRequest rateRequest);
}
