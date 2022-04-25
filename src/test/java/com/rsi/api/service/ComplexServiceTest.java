package com.rsi.api.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ComplexServiceTest {

	private static ComplexService complexService;

	@BeforeAll
	public static void setup() {
		complexService = Mockito.spy(new ComplexService());
	}

	@Test
	void testSpy() {
		assertEquals(3, complexService.getStep3());
		Mockito.verify(complexService).getStep1();
	}

}
