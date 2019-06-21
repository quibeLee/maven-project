package com.hotel.aop;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 404页面控制
 * 
 * @author liheng
 *
 */
@Controller
public class NotFoundException implements ErrorController {

	@Override
	public String getErrorPath() {

		return "/error";
	}

	@RequestMapping("/error")
	public String errorinfo() {
		return "errorinfo";
	}

}
