package com.microservices.orderservice.service;

import com.microservices.orderservice.request.OrderRequest;

public interface OrderService {

    public void placeOrder(OrderRequest orderRequest);
}
