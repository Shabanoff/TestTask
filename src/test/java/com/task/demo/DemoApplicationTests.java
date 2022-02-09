package com.task.demo;

import com.task.demo.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	UserController controller;
	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}



}
