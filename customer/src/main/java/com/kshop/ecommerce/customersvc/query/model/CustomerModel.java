package com.kshop.ecommerce.customersvc.query.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kshop.ecommerce.customersvc.domain.valueobject.CustomerStatus;
import com.kshop.ecommerce.customersvc.domain.valueobject.Gender;

import lombok.Data;

/**
 * Customer
 */
@Entity
@Table
@Data
public class CustomerModel {

    @Id
    private String id;
    @Column(unique = true)
    private String detailId;
    private String name;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private CustomerStatus status;
}