package com.kshop.ecommerce.customersvc.endpoint;

import java.util.List;
import java.util.UUID;

import com.kshop.ecommerce.customersvc.domain.command.ActivateCustomerCommand;
import com.kshop.ecommerce.customersvc.domain.command.CreateCustomerCommand;
import com.kshop.ecommerce.customersvc.query.model.CustomerModel;
import com.kshop.ecommerce.customersvc.query.spec.FindAllCustomerSpec;
import com.kshop.ecommerce.customersvc.query.spec.FindCustomerByIdSpec;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Customer
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CreateCustomerCommand command) {
        this.commandGateway.sendAndWait(command);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> activateCustomer(@PathVariable UUID id) {
        this.commandGateway.sendAndWait(new ActivateCustomerCommand(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable String id) {
        CustomerModel customer = this.queryGateway.query(new FindCustomerByIdSpec(id), CustomerModel.class).join();
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerModel>> getAllCustomer() {
        List<CustomerModel> customers = this.queryGateway
                .query(new FindAllCustomerSpec(), ResponseTypes.multipleInstancesOf(CustomerModel.class)).join();
        return ResponseEntity.ok(customers);
    }

}