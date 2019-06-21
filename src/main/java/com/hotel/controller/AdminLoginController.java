package com.hotel.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.model.Admin;
import com.hotel.service.AdminService;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;

/**
 * 管理员登陆
 * 
 * @author liheng
 *
 */
@Controller

public class AdminLoginController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private UserService userService;

//登陆
	@RequestMapping("dologin")
	public String login(Admin admin, @RequestParam("username") String username,
			@RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
		int roomNumber = roomService.selectAllCount();
		int lastRoomNumber = roomService.selectAllLastCount();
		int userNumber = userService.selectAllCount();
		int adminNumber = adminService.selectAllCount();
		admin.setUsername(username);
		admin.setPassword(password);
		admin = adminService.dologin(admin);

		if (admin != null) {
			session.setAttribute("admin", admin);
			session.setAttribute("roomNumber", roomNumber);
			session.setAttribute("lastRoomNumber", lastRoomNumber);
			session.setAttribute("userNumber", userNumber);
			session.setAttribute("adminNumber", adminNumber);
			return "redirect:/index";
		} else {
			session.setAttribute("msg", "账号或密码不正确");
			return "redirect:/login";
		}

	}

//注销
	@RequestMapping("loginto")
	public String loginto(HttpSession session) {
		session.removeAttribute("admin");
		System.out.println("已注销");
		return "redirect:/login";
	}

}
