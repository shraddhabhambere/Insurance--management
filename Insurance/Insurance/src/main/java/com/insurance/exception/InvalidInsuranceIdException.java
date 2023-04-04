package com.insurance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidInsuranceIdException extends RuntimeException {
	
	private String message;

	public InvalidInsuranceIdException() {
		this.message = "";
	}
	public InvalidInsuranceIdException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "Invalid insurance id " + this.message;
	}

}
