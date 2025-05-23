package com.inditex.rater.dataaccess.product.repository;

import com.inditex.rater.dataaccess.config.DataAccessTestConfiguration;
import com.inditex.rater.dataaccess.product.adapter.ProductRepositoryImpl;
import com.inditex.rater.dataaccess.product.entity.ProductEntity;
import com.inditex.rater.dataaccess.product.mapper.ProductDataAccessMapper;
import com.inditex.rater.dataaccess.product.mapper.ProductDataAccessMapperImpl;
import com.inditex.rater.domain.entity.Product;
import com.inditex.rater.domain.valueobject.ProductId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = {
        DataAccessTestConfiguration.class,
        ProductDataAccessMapperImpl.class})
class ProductRepositoryTest {

    private final Long productId = 35455L;
    private final String productName = "First Product";

    private final Product product = Product.of(
            ProductId.of(this.productId), this.productName);

    private final ProductEntity productEntity = new ProductEntity(this.productId, this.productName);

    @Autowired
    private ProductJpaRepository productJpaRepository;
    @Autowired
    private ProductDataAccessMapper productDataAccessMapper;

    private ProductRepositoryImpl productRepository;

    @BeforeAll
    void setUp() {
        this.productRepository = new ProductRepositoryImpl(
                this.productJpaRepository, this.productDataAccessMapper);
    }

    @Test
    void can_get_by_id() {
        when(this.productJpaRepository.findById(this.productId)).thenReturn(Optional.of(this.productEntity));
        assertEquals(Optional.of(this.product),
                this.productRepository.getByProductId(ProductId.of(this.productId)));
    }

    @Test
    void can_get_by_id_no_product() {
        assertEquals(Optional.empty(),
                this.productRepository.getByProductId(ProductId.of(this.productId)));
    }

}