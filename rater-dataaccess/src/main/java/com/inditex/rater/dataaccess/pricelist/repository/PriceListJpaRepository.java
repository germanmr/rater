package com.inditex.rater.dataaccess.pricelist.repository;

import com.inditex.rater.dataaccess.pricelist.entity.PriceListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceListJpaRepository extends JpaRepository<PriceListEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT " +
            " id, priority, brand_id, product_id, currency, price, start_date, end_date " +
            " FROM PRICES " +
            " WHERE brand_id=:brandId AND product_id=:productId AND " +
            " :applyDate >= start_date AND :applyDate <= end_date" +
            " ORDER BY priority DESC LIMIT 1")
    PriceListEntity findByBrandAndProductAndApplyDate(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("applyDate") LocalDateTime applyDate);
}