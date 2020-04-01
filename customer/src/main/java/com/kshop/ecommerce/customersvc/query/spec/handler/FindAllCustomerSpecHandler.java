package com.kshop.ecommerce.customersvc.query.spec.handler;

import java.util.List;

import com.kshop.ecommerce.customersvc.query.model.CustomerModel;
import com.kshop.ecommerce.customersvc.query.spec.FindAllCustomerSpec;

/**
 * FindAllCustomerSpecHandler
 */
public interface FindAllCustomerSpecHandler {

    List<CustomerModel> handle(FindAllCustomerSpec spec);
}