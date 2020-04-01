package com.kshop.ecommerce.customersvc.domain.event;

import java.util.UUID;

import com.kshop.ecommerce.customersvc.domain.entity.CustomerDetail;
import com.kshop.ecommerce.customersvc.domain.valueobject.CustomerStatus;

import lombok.Data;

/**
 * CustomerCreatedEvent
 */
@Data
public class CustomerCreatedEvent implements CustomerEvent {
    private final UUID id;
    private final CustomerDetail customerDetail;
    private final CustomerStatus status;
}