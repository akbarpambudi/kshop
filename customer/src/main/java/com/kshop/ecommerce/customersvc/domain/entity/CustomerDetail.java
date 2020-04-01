package com.kshop.ecommerce.customersvc.domain.entity;

import java.util.UUID;

import com.kshop.ecommerce.customersvc.domain.valueobject.Email;
import com.kshop.ecommerce.customersvc.domain.valueobject.Gender;
import com.kshop.ecommerce.customersvc.domain.valueobject.Name;
import com.kshop.ecommerce.customersvc.domain.valueobject.PhoneNumber;

import org.axonframework.modelling.command.EntityId;

import lombok.Data;

/**
 * CustomerDetail
 */
@Data
public class CustomerDetail {
    @EntityId
    private final UUID id;
    private Name name;
    private Gender gender;
    private Email email;
    private PhoneNumber phoneNumber;
}