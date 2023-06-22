package com.orcaaa.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private String customerId;
    private String productId;
    private int quantity;
    private boolean failureScenario;

    // constructors, getters, setters
}
