package com.demo.bank.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.bank.appconstants.ApplicationConstants;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(TransactionException.class)
	public ExceptionResponse handleException(final TransactionException invalidUserException,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(invalidUserException.getMessage());
		error.setStatus(ApplicationConstants.TRANSACTION_FAILURE_CODE);
		return error;
	}
	
	@ExceptionHandler(UserRegistrationException.class)
	public ExceptionResponse handleException(final UserRegistrationException UserException,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(UserException.getMessage());
		error.setStatus(ApplicationConstants.TRANSACTION_FAILURE_CODE);
		return error;
	}

}
