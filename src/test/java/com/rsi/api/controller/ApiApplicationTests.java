package com.rsi.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsi.api.ApiApplication;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(ApiApplication.class)
class ApiApplicationTests {

	@Autowired
	public MockMvc mockMvc;

	@Autowired
	public ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void mainTest() throws Exception {
		ApiApplication apiApplication = new ApiApplication();
		apiApplication.main(new String[]{""});
	}

}
