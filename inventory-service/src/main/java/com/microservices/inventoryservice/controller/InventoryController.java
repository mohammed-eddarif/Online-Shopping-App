package com.microservices.inventoryservice.controller;

import com.microservices.inventoryservice.response.InventoryResponse;
import com.microservices.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory-service")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    // there are 2 extract values from http request :

    // PathVariable format :  http://localhost:8082/api/inventory-service/iphone13,iphone13-red

    // RequestParam format :  http://localhost:8082/api/inventory-service?skuCode=iphone13&skuCode=iphone13-red


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
