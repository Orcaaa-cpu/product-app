package com.orcaaa.controller;

import com.orcaaa.entity.Customer;
import com.orcaaa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public Customer editCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        return customerService.editCustomer(customerId, customer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {
        return customerService.getCustomerById(customerId);
    }
}
