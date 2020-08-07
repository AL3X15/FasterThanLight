package com.spring.henallux.javawebproject.controllers;


import org.springframework.context.MessageSource;


public abstract class ControllerBase {

	private MessageSource messageSource;

	public ControllerBase(MessageSource messageSource) {
		setMessageSource(messageSource);
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
