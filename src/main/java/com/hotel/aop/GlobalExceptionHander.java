package com.hotel.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常捕获
 * 
 * @author liheng
 *
 */
@ControllerAdvice
public class GlobalExceptionHander {

	@ExceptionHandler(RuntimeException.class)
	public String exceptionHander() {
		return "errorinfo";
	}
}
