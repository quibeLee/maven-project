package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.model.Admin;
import com.hotel.service.AdminService;

import net.sf.json.JSONObject;

/**
 * 管理员的增删改查
 * 
 * @author liheng
 *
 */
@Controller
public class AdminCRUDController {
	@Autowired
	private AdminService adminService;

// 添加管理员账户
	@RequestMapping("doinsert")
	public String doinsert(@RequestParam("username") String username, @RequestParam("password") String password) {

		Admin admin = new Admin();

		admin.setUsername(username);
		admin.setPassword(password);
		adminService.insert(admin);
		return "redirect:/addAdmin";

	}

//	修改密码
	@RequestMapping("dochange")
	public String dochange(@RequestParam("username") String username, @RequestParam("newpassword") String newpassword) {
		adminService.updatePassword(username, newpassword);
		return "redirect:/changepassword";

	}

//更新个人信息
	@RequestMapping("doinfo")
	public String doinfo(@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("sex") String sex) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setEmail(email);
		admin.setPhone(phone);
		admin.setSex(sex);
		adminService.updateInfo(admin);

		return "redirect:/admininfo";
	}

	@RequestMapping(value = "/deleteAdmin", method = RequestMethod.POST)
	@ResponseBody
	public String deleteByName(@RequestParam("username") String username) {

		adminService.deleteByName(username);

		return "200";
	}

//管理员列表
	@RequestMapping("/admin")
	@ResponseBody
	public String userList(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize,
			HttpServletRequest request) {
		String userString = request.getParameter("keyword");

		if (adminService.selectByName(userString) != null) {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<Admin> adminlist = new ArrayList<Admin>();
			adminlist.add(adminService.selectByName(userString));
			PageInfo<Admin> pageInfo = new PageInfo<>(adminlist);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", adminlist);
			return map.toString();
		} else {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<Admin> adminlist = adminService.selectAll(pageNum, pageSize);
			PageInfo<Admin> pageInfo = new PageInfo<>(adminlist);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", adminlist);
			return map.toString();
		}

	}

//ajax验证昵称是否被使用
	@RequestMapping("dore")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		Admin admin = adminService.selectByName(name);
		// 判断昵称是否已被使用
		if (admin != null) {
			pw.print(true);
		} else {
			pw.print(false);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
