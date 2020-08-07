package com.spring.henallux.javawebproject.exceptions;

public class EmailAlreadyUse extends Exception {
	private String field = "email";
	private String errorCode = "AlreadyExist.user";
	private String defaultMessage = "user with this email already exist";

	public String getField() {
		return field;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}
}
