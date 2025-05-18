package com.inditex.rater.dataaccess.brand.adapter;

import com.inditex.rater.dataaccess.brand.mapper.BrandDataAccessMapperImpl;
import com.inditex.rater.dataaccess.brand.repository.BrandJpaRepository;
import com.inditex.rater.dataaccess.config.DataAccessTestConfiguration;
import com.inditex.rater.dataaccess.brand.entity.BrandEntity;
import com.inditex.rater.dataaccess.brand.mapper.BrandDataAccessMapper;
import com.inditex.rater.domain.entity.Brand;
import com.inditex.rater.domain.valueobject.BrandId;
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
        BrandDataAccessMapperImpl.class})
class BrandRepositoryImplTest {

    private final Long brandId = 35455L;
    private final String brandName = "First Brand";

    private final Brand brand = Brand.of(
            BrandId.of(brandId), brandName);

    private final BrandEntity brandEntity = new BrandEntity(brandId, brandName);

    @Autowired
    private BrandJpaRepository brandJpaRepository;
    @Autowired
    private BrandDataAccessMapper brandDataAccessMapper;

    private BrandRepositoryImpl brandRepository;

    @BeforeAll
    void setUp() {
        this.brandRepository = new BrandRepositoryImpl(
                brandJpaRepository, brandDataAccessMapper);
    }

    @Test
    void can_get_by_id() {
        when(this.brandJpaRepository.findById(brandId)).thenReturn(Optional.of(brandEntity));
        assertEquals(Optional.of(brand),
                this.brandRepository.getByBrandId(BrandId.of(brandId)));
    }

    @Test
    void can_get_by_id_no_brand() {
        assertEquals(Optional.empty(),this.brandRepository.getByBrandId(BrandId.of(brandId)));
    }

}