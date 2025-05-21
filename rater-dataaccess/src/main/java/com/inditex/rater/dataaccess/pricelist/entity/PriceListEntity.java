package com.inditex.rater.dataaccess.pricelist.entity;

import com.inditex.rater.dataaccess.brand.entity.BrandEntity;
import com.inditex.rater.dataaccess.product.entity.ProductEntity;
import com.inditex.rater.domain.valueobject.CurrencyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "prices")
@Entity
public class PriceListEntity {
    @Id
    private Long id;
    private Integer priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    private BigDecimal price;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
