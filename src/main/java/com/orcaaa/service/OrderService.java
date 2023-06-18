package com.orcaaa.service;

import com.orcaaa.dtos.OrderRequest;
import com.orcaaa.entity.Customer;
import com.orcaaa.entity.Order;
import com.orcaaa.entity.Product;
import com.orcaaa.exception.ResourceNotFoundException;
import com.orcaaa.repository.CustomerRepository;
import com.orcaaa.repository.OrderRepository;
import com.orcaaa.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest) {
        String customerId = orderRequest.getCustomerId();
        String productId = orderRequest.getProductId();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        BigDecimal productPrice = new BigDecimal(product.getProductPrice());
        int quantity = orderRequest.getQuantity();
        BigDecimal amount = productPrice.multiply(BigDecimal.valueOf(quantity));

        Order order = Order.builder()
                .orderId(UUID.randomUUID().toString())
                .customer(customer)
                .customerName(customer.getCustomerName())
                .product(product)
                .quantity(quantity)
                .amount(amount)
                .orderDate(LocalDateTime.now())
                .build();

        // Simulate failure scenario
        if (orderRequest.isFailureScenario()) {
            throw new RuntimeException("Failed to create order.");
        }

        return orderRepository.save(order);
    }
}
