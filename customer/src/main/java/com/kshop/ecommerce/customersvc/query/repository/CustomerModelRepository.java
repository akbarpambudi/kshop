package com.kshop.ecommerce.customersvc.query.repository;

import com.kshop.ecommerce.customersvc.query.model.CustomerModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 */
@Repository
public interface CustomerModelRepository extends JpaRepository<CustomerModel, String> {

}