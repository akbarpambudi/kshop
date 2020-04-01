package com.kshop.ecommerce.customersvc.domain.aggregate;

import java.util.UUID;

import com.kshop.ecommerce.customersvc.domain.command.ActivateCustomerCommand;
import com.kshop.ecommerce.customersvc.domain.command.CreateCustomerCommand;
import com.kshop.ecommerce.customersvc.domain.command.handler.ActivateCustomerCommandHandler;
import com.kshop.ecommerce.customersvc.domain.command.handler.CreateCustomerCommandHandler;
import com.kshop.ecommerce.customersvc.domain.entity.CustomerDetail;
import com.kshop.ecommerce.customersvc.domain.event.CustomerActivatedEvent;
import com.kshop.ecommerce.customersvc.domain.event.CustomerCreatedEvent;
import com.kshop.ecommerce.customersvc.domain.event.handler.CustomerActivatedEventHandler;
import com.kshop.ecommerce.customersvc.domain.event.handler.CustomerCreatedEventHandler;
import com.kshop.ecommerce.customersvc.domain.valueobject.CustomerStatus;
import com.kshop.ecommerce.customersvc.domain.valueobject.Email;
import com.kshop.ecommerce.customersvc.domain.valueobject.Name;
import com.kshop.ecommerce.customersvc.domain.valueobject.PhoneNumber;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.Getter;

/**
 * Customer
 */
@Getter
@Aggregate
public class Customer implements CreateCustomerCommandHandler, ActivateCustomerCommandHandler,
        CustomerCreatedEventHandler, CustomerActivatedEventHandler {
    @AggregateIdentifier
    private UUID id;
    @AggregateMember
    private CustomerDetail detail;
    private CustomerStatus status;

    @CommandHandler
    public Customer(CreateCustomerCommand command) {
        this.handle(command);
    }

    @Override
    public void handle(CreateCustomerCommand command) {
        UUID id = command.getId();
        CustomerDetail detail = new CustomerDetail(UUID.randomUUID());
        detail.setEmail(Email.fromString(command.getEmail()));
        detail.setGender(command.getGender());
        detail.setName(Name.fromString(command.getName()));
        detail.setPhoneNumber(PhoneNumber.fromString(command.getPhoneNumber()));
        AggregateLifecycle.apply(new CustomerCreatedEvent(id, detail, CustomerStatus.PENDING));
    }

    @CommandHandler
    public void handle(ActivateCustomerCommand command) {
        AggregateLifecycle.apply(new CustomerActivatedEvent(command.getId(), CustomerStatus.ACTIVE));

    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        this.id = event.getId();
        this.detail = event.getCustomerDetail();
        this.status = event.getStatus();
    }

    @EventSourcingHandler
    public void on(CustomerActivatedEvent event) {
        this.status = event.getStatus();
    }

}