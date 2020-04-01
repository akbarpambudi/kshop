package com.kshop.ecommerce.customersvc.query.eventhandler;

import com.kshop.ecommerce.customersvc.domain.event.CustomerActivatedEvent;
import com.kshop.ecommerce.customersvc.domain.event.CustomerCreatedEvent;
import com.kshop.ecommerce.customersvc.domain.event.handler.CustomerActivatedEventHandler;
import com.kshop.ecommerce.customersvc.domain.event.handler.CustomerCreatedEventHandler;
import com.kshop.ecommerce.customersvc.query.model.CustomerModel;
import com.kshop.ecommerce.customersvc.query.repository.CustomerModelRepository;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

/**
 * CustomerEventHandler
 */
@Service
public class CustomerEventHandler implements CustomerCreatedEventHandler, CustomerActivatedEventHandler {

    private final CustomerModelRepository repository;

    public CustomerEventHandler(CustomerModelRepository repository) {
        this.repository = repository;
    }

    @Override
    @EventHandler
    public void on(CustomerActivatedEvent event) {
        CustomerModel customer = this.repository.getOne(event.getId().toString());
        customer.setStatus(event.getStatus());
        this.repository.save(customer);
    }

    @Override
    @EventHandler
    public void on(CustomerCreatedEvent event) {
        CustomerModel customer = new CustomerModel();
        customer.setId(event.getId().toString());
        customer.setDetailId(event.getCustomerDetail().getId().toString());
        customer.setGender(event.getCustomerDetail().getGender());
        customer.setEmail(event.getCustomerDetail().getEmail().toString());
        customer.setPhoneNumber(event.getCustomerDetail().getPhoneNumber().toString());
        customer.setStatus(event.getStatus());
        customer.setName(event.getCustomerDetail().getName().toString());
        this.repository.save(customer);

    }

}