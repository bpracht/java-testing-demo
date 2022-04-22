package com.rsi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.api.service.FactorialService;

@RestController
@RequestMapping("/factorial")
public class FactorialController {
	
	FactorialService factorialService;
	
	@Autowired
	FactorialController(FactorialService factorialService) {
		this.factorialService = factorialService;
	}

	@GetMapping("{number}")
	Long getFactorial(@PathVariable Long number) {
		return factorialService.getFactorial(number);
	}
	
	@GetMapping("/hello")
	String getStatus() {
		return "Hello";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}

}