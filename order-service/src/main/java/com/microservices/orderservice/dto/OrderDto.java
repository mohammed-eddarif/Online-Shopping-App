package com.microservices.orderservice.dto;

import com.microservices.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;

    private String OrderNumber;

    private List<OrderLineItems> orderLineItems;
}
