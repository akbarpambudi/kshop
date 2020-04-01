package com.kshop.ecommerce.customersvc.domain.valueobject;

import lombok.Getter;

/**
 * Email
 */
@Getter
public class Email {

    private final String value;

    public static class InvalidFormatException extends RuntimeException {

        private static final long serialVersionUID = 1L;

    }

    public static Email fromString(String value) {
        return new Email(value);
    }

    private Email(String value) {
        validateFormat(value);
        this.value = value;
    }

    private void validateFormat(String value) {

    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.value.equals(obj);
    }
}