package com.kshop.ecommerce.customersvc.domain.valueobject;

/**
 * Gender
 */
public enum Gender {
    MALE("MALE"), FEMALE("FEMALE");

    private Gender(String gender) {
        this.gender = gender;
    }

    private String gender;

    @Override
    public String toString() {
        return gender;
    }
}