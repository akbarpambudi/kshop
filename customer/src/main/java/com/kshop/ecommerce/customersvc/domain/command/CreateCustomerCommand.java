package com.kshop.ecommerce.customersvc.domain.command;

import java.util.UUID;

import com.kshop.ecommerce.customersvc.domain.valueobject.Gender;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

/**
 * CreateCustomerCommand
 */
@Data
public class CreateCustomerCommand implements CustomerCommand {
    @TargetAggregateIdentifier
    private final UUID id;
    private final String name;
    private final Gender gender;
    private final String email;
    private final String phoneNumber;
}