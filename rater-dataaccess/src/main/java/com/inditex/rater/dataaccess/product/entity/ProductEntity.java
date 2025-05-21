package com.inditex.rater.dataaccess.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
@Entity
public class ProductEntity {
    @Id
    private Long id;
    private String name;
}
