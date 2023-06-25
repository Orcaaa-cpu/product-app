package com.orcaaa.dtos.response;

import com.orcaaa.entity.Order;
import lombok.Data;

@Data


public class OrderResponse extends ProductResponse {

    Order order;
    private String message;
    private String status;
}
