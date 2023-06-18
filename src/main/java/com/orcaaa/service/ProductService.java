package com.orcaaa.service;

import com.orcaaa.entity.Product;
import com.orcaaa.exception.ResourceNotFoundException;
import com.orcaaa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        product.setProductId(uuidString);
        return productRepository.save(product);
    }

    public Product editProduct(String productId, Product product) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        existingProduct.setProductPrice(product.getProductPrice());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setStock(product.getStock());

        return productRepository.save(existingProduct);
    }

    public Product getProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
    }
}
