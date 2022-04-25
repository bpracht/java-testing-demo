package com.rsi.api.service;

public class ComplexService {

	public int getStep1() {
		return 1;
	}

	public int getStep2() {
		return 2;
	}

	public int getStep3() {
		return getStep1() + getStep2();
	}

}
