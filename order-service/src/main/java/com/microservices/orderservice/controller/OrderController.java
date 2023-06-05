package com.microservices.orderservice.controller;

import com.microservices.orderservice.request.OrderRequest;
import com.microservices.orderservice.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderServiceImpl.placeOrder(orderRequest);
        return "Order Passed Successfully";
    }
}
