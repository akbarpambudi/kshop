package com.kshop.ecommerce.customersvc.domain.valueobject;

import lombok.Getter;

/**
 * Name
 */
@Getter
public class Name {
    private final String value;

    public static Name fromString(String value) {
        return new Name(value);
    }

    private Name(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return this.value.equals(obj);
    }
}