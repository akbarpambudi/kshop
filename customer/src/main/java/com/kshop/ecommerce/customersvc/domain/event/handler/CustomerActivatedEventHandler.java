package com.kshop.ecommerce.customersvc.domain.event.handler;

import com.kshop.ecommerce.customersvc.domain.event.CustomerActivatedEvent;

/**
 * CustomerActivatedEventHandler
 */
public interface CustomerActivatedEventHandler {
    void on(CustomerActivatedEvent event);
}