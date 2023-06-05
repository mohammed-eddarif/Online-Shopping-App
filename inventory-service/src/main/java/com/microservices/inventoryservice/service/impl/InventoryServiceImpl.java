package com.microservices.inventoryservice.service.impl;

import com.microservices.inventoryservice.repository.InventoryRepository;
import com.microservices.inventoryservice.response.InventoryResponse;
import com.microservices.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skucode) {
        return inventoryRepository.findBySkuCodeIn(skucode).stream()
                .map(Inventory -> InventoryResponse.builder()
                        .skuCode(Inventory.getSkuCode())
                        .isInStock(Inventory.getQuantity() > 0)
                        .build())
                .toList();
    }
}
