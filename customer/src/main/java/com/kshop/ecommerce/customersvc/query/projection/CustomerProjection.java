package com.kshop.ecommerce.customersvc.query.projection;

import java.util.List;

import com.kshop.ecommerce.customersvc.query.model.CustomerModel;
import com.kshop.ecommerce.customersvc.query.repository.CustomerModelRepository;
import com.kshop.ecommerce.customersvc.query.spec.FindAllCustomerSpec;
import com.kshop.ecommerce.customersvc.query.spec.FindCustomerByIdSpec;
import com.kshop.ecommerce.customersvc.query.spec.handler.FindAllCustomerSpecHandler;
import com.kshop.ecommerce.customersvc.query.spec.handler.FindCustomerByIdSpecHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

/**
 * CustomerProjection
 */
@Service
public class CustomerProjection implements FindAllCustomerSpecHandler, FindCustomerByIdSpecHandler {

    private final CustomerModelRepository repository;

    public CustomerProjection(CustomerModelRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public CustomerModel handle(FindCustomerByIdSpec spec) {
        return this.repository.getOne(spec.getId());
    }

    @QueryHandler
    public List<CustomerModel> handle(FindAllCustomerSpec spec) {
        return this.repository.findAll();
    }

}