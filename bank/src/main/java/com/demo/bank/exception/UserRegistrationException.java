package com.demo.bank.exception;

public class UserRegistrationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserRegistrationException() {
		super();
	}

	public UserRegistrationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserRegistrationException(String message) {
		super(message);
	}

	public UserRegistrationException(Throwable cause) {
		super(cause);
	}

}
