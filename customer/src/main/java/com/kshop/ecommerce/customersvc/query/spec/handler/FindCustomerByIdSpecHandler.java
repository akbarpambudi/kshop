package com.kshop.ecommerce.customersvc.query.spec.handler;

import com.kshop.ecommerce.customersvc.query.model.CustomerModel;
import com.kshop.ecommerce.customersvc.query.spec.FindCustomerByIdSpec;

/**
 * FindCustomerByIdHandler
 */
public interface FindCustomerByIdSpecHandler {

    CustomerModel handle(FindCustomerByIdSpec spec);

}