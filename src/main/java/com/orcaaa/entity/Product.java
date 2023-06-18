package com.orcaaa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "stock")
    private int stock;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    // constructors, getters, setters
}
