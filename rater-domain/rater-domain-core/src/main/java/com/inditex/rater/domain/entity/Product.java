package com.inditex.rater.domain.entity;

import com.inditex.rater.domain.base.AggregateRoot;
import com.inditex.rater.domain.valueobject.ProductId;

import java.util.Objects;

public final class Product extends AggregateRoot<ProductId> {

    private final String name;

    private Product(Builder builder) {
        super.setId(builder.id);
        name = builder.name;
    }

    public String getName() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public static final class Builder {
        private ProductId id;
        private String name;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder productId(ProductId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}