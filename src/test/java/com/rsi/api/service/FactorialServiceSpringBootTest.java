package com.rsi.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rsi.api.service.config.TestConfig;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=TestConfig.class)
class FactorialServiceSpringBootTest {

	private static FactorialService factorialService;

	@BeforeAll
	public static void setup() {
		factorialService = new FactorialServiceImpl();
	}

	@Test
	void testNegativeNumber() {
		assertThrows(IllegalArgumentException.class, () -> 
			factorialService.getFactorial(-1)
		);

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
