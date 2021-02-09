package com.pathfinder.restservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pathfinder.restservice.controller.TestController;

@SpringBootTest
class PathfinderApplicationTests {

	@Autowired
	TestController testController;
	
	@Test
	void contextLoads() {
		assertThat(testController).isNotNull();
		
		//https://spring.io/guides/gs/testing-web/
	}

}
