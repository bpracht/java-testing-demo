package com.rsi.api.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FactorialServiceTest {

	private static FactorialService factorialService;

	@BeforeAll
	public static void setup() {
		factorialService = new FactorialServiceImpl();
	}

	@Test
	void testNegativeNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			factorialService.getFactorial(-1);
		});

	}

	@Test
	void testZero() {
		long expectedValue = 1;
		long actualValue = factorialService.getFactorial(0);
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testPositiveNumbers() {
		long expectedValue = 5 * 4 * 3 * 2 * 1;
		long actualValue = factorialService.getFactorial(5);
		assertEquals(expectedValue, actualValue);
	}
}
