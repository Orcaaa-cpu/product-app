package com.orcaaa.controller;

import com.orcaaa.entity.Customer;
import com.orcaaa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        log.info("Entering addCustomer method : ....");
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
