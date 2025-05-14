package com.inditex.rater.domain.ports.input.service;

import com.inditex.rater.domain.dto.RateProductRequest;
import com.inditex.rater.domain.dto.RateProductResponse;

public interface RateApplicationService {

    RateProductResponse rateProduct(final RateProductRequest rateRequest);
}
