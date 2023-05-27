package com.microservices.orderservice.repository;

import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.model.OrderLineItems;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.ArrayList;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void OrderRepository_save_ReturnOrder(){
        // Arrange

        OrderLineItems orderLineItems1 = OrderLineItems.builder()
                .skucode("p1")
                .price(BigDecimal.valueOf(1200))
                .quantity(2)
                .build();

        OrderLineItems orderLineItems2 = OrderLineItems.builder()
                .skucode("p2")
                .price(BigDecimal.valueOf(1200))
                .quantity(2)
                .build();

        ArrayList<OrderLineItems> o = new ArrayList<OrderLineItems>();
        o.add(orderLineItems1);
        o.add(orderLineItems2);

        Order order = Order.builder()
                .OrderNumber("123")
                .orderLineItems(o)
                .build();
        // Act

        Order savedOrder = orderRepository.save(order);

        // Assert

        Assertions.assertThat(savedOrder).isNotNull();
        Assertions.assertThat(savedOrder.getId()).isGreaterThan(0);

    }
}
