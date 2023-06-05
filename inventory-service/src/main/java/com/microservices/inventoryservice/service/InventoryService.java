package com.microservices.inventoryservice.service;

import com.microservices.inventoryservice.response.InventoryResponse;

import java.util.List;

public interface InventoryService {

    public List<InventoryResponse> isInStock(List<String> skucode);
}
