package com.barclays.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}
}
