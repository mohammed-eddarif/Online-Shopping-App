package com.microservices.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class OrderServiceApplicationTests {

	// given/when/then format  BDD style
	@Container
	public static MySQLContainer mySQLContainer = new MySQLContainer("mysql:latest");

	@Autowired
	private MockMvc mockMvc;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
//		dynamicPropertyRegistry.add("spring.", mySQLContainer::getJdbcUrl);
	}

	@Test
	public void givenOrder_whenPlaceOrder_thenOrderIdReturned(){
		//given : setup or predictions

		//when : action

		//then : verify the output
	}

	@Test
	void contextLoads() {
	}

}
