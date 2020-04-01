package com.kshop.ecommerce.customersvc.domain.command.handler;

import com.kshop.ecommerce.customersvc.domain.command.CreateCustomerCommand;

/**
 * CraeteCustomerCommandHandler
 */
public interface CreateCustomerCommandHandler {
    void handle(CreateCustomerCommand command);
}