package com.kshop.ecommerce.customersvc.domain.event.handler;

import com.kshop.ecommerce.customersvc.domain.event.CustomerCreatedEvent;

/**
 * CustomerCreatedEventHandler
 */
public interface CustomerCreatedEventHandler {
    void on(CustomerCreatedEvent event);
}