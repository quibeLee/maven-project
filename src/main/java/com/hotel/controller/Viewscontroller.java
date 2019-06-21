package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图控制器
 * 
 * @author liheng
 *
 */
@Controller
public class Viewscontroller {

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping("index")
	public String index() {
		return "index";
	}

	@GetMapping("main")
	public String main() {
		return "main";
	}

	@GetMapping("admininfo")
	public String admininfo() {
		return "admininfo";
	}

	@GetMapping("addAdmin")
	public String addAdmin() {
		return "addAdmin";
	}

	@RequestMapping("adminlist")
	public String adminlist2() {
		return "adminlist";
	}

	@RequestMapping("changepassword")
	public String changepwd() {

		return "changepassword";
	}

	@GetMapping("userlist")
	public String userlist() {
		return "userlist";
	}

	@GetMapping("adduser")
	public String adduser() {
		return "adduser";
	}

	@GetMapping("roomlist")
	public String roomlist() {
		return "roomlist";
	}

	@GetMapping("addroom")
	public String addroom() {
		return "addroom";
	}

	@GetMapping("foodlist")
	public String foodlist() {
		return "foodlist";
	}

	@GetMapping("addfood")
	public String addfood() {
		return "addfood";
	}

	@GetMapping("orderlist")
	public String orderlist() {
		return "orderlist";
	}

	@GetMapping("livelist")
	public String livelist() {
		return "livelist";
	}

	@GetMapping("foodorder")
	public String foodorder() {
		return "foodorder";
	}

	@GetMapping("foodorderlist")
	public String foodorderlist() {

		return "foodorderlist";
	}

	@GetMapping("errorinfo")
	public String errorinfo() {

		return "errorinfo";
	}

}
