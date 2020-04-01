package com.kshop.ecommerce.customersvc.domain.command.handler;

import com.kshop.ecommerce.customersvc.domain.command.ActivateCustomerCommand;

/**
 * ActivateCustomerCommandHandler
 */
public interface ActivateCustomerCommandHandler {
    void handle(ActivateCustomerCommand command);
}