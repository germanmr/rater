package com.inditex.rater.dataaccess.brand.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "brands")
@Entity
public class BrandEntity {
    @Id
    private Long id;
    private String name;
}
