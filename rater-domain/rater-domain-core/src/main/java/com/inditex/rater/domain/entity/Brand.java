package com.inditex.rater.domain.entity;

import com.inditex.rater.domain.base.AggregateRoot;
import com.inditex.rater.domain.valueobject.BrandId;

import java.util.Objects;

public final class Brand extends AggregateRoot<BrandId> {

    private final String name;

    private Brand(Builder builder) {
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
        Brand brand = (Brand) o;
        return Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                '}';
    }

    public static final class Builder {
        private BrandId id;
        private String name;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder brandId(BrandId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Brand build() {
            return new Brand(this);
        }
    }
}