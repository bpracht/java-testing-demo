package com.rsi.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsi.api.controller.FactorialController;
import com.rsi.api.service.FactorialService;

@WebMvcTest(FactorialController.class)
class FactorialControllerTest {

	@Autowired
	public MockMvc mockMvc;

	@Autowired
	public ObjectMapper objectMapper;

	@MockBean
	private FactorialService factorialService;


	@Test
	void contextLoads() {
	}

	@Test
	public void rootTest() throws Exception {
		final MockHttpServletRequestBuilder request = get("/");
		mockMvc.perform(request).andExpect(status().isNotFound());
	}

	@Test
	public void getFactorialGoodTest() throws Exception {
		final MockHttpServletRequestBuilder request = get("/factorial/5");
		mockMvc.perform(request).andExpect(status().isOk());
	}

	@Test
	public void getFactorialBadTest() throws Exception {
		final MockHttpServletRequestBuilder request = get("/factorial/x");
		mockMvc.perform(request).andExpect(status().isBadRequest());
	}

	@Test
	public void getStatusTest() throws Exception {
		final MockHttpServletRequestBuilder request = get("/factorial/hello");
		mockMvc.perform(request).andExpect(status().isOk());
	}
}
