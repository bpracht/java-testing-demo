package com.rsi.api.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialServiceImpl implements FactorialService {

	@Override
	public long getFactorial(long number) {
		long result = 1;
		if(number < 0) {
			throw new IllegalArgumentException("Negative numbers are not supported");
		} 
		for(long i = number ; i > 0 ; i--) {
			result *= i;
		}
		return result;
	}

}
