package com.inditex.rater.dataaccess.pricelist.repository;

import com.inditex.rater.dataaccess.pricelist.entity.PriceListEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceListJpaRepository extends JpaRepository<PriceListEntity, Long> {
    @Query("SELECT p FROM PriceListEntity p " +
            "WHERE p.brandEntity.id = :brandId " +
            "AND p.productEntity.id = :productId " +
            "AND :applyDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    List<PriceListEntity> findByBrandAndProductAndApplyDate(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("applyDate") LocalDateTime applyDate,
            Pageable pageable);
}