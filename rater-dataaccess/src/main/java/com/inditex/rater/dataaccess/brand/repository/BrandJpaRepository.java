package com.inditex.rater.dataaccess.brand.repository;

import com.inditex.rater.dataaccess.brand.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandJpaRepository extends JpaRepository<BrandEntity,Long> {
}
