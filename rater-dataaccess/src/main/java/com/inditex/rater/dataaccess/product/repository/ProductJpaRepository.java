package com.inditex.rater.dataaccess.product.repository;

import com.inditex.rater.dataaccess.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity,Long> {
}
