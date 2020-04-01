package com.kshop.ecommerce.customersvc.domain.command;

import java.util.UUID;

import lombok.Data;

/**
 * ActivateCustomerCommand
 */
@Data
public class ActivateCustomerCommand {

    private final UUID id;

}