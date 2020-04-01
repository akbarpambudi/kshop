package com.kshop.ecommerce.customersvc.domain.valueobject;

import lombok.Getter;

/**
 * PhoneNumber
 */
@Getter
public class PhoneNumber {

    private final String value;

    public static PhoneNumber fromString(String value) {
        return new PhoneNumber(value);
    }

    private PhoneNumber(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        return this.value.equals(obj);
    }
}