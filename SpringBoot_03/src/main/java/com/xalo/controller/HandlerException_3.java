package com.xalo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class HandlerException_3 {

	@ExceptionHandler(value = ArithmeticException.class)
	@ResponseBody
	public String first(Exception exception) {
		exception.printStackTrace();
		return "errorJson";
	}

}
