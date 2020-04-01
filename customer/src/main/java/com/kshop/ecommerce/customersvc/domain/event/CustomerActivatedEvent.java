package com.kshop.ecommerce.customersvc.domain.event;

import java.util.UUID;

import com.kshop.ecommerce.customersvc.domain.valueobject.CustomerStatus;

import lombok.Data;

/**
 * CustomerActivatedEvent
 */
@Data
public class CustomerActivatedEvent implements CustomerEvent {
    private final UUID id;
    private final CustomerStatus status;
}