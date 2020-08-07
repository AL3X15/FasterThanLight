package com.spring.henallux.javawebproject.exceptions;

public class UserAlreadyExist extends Exception {
	private String field = "username";
	private String errorCode = "AlreadyExist.user";
	private String defaultMessage = "user already exist";

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
