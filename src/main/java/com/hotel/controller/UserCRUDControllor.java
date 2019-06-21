package com.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hotel.model.User;
import com.hotel.service.UserService;

import net.sf.json.JSONObject;

/**
 * 用户模块的增删改查
 * 
 * @author liheng
 *
 */
@Controller
public class UserCRUDControllor {
	@Autowired
	private UserService userService;

	@RequestMapping("userinsert")
	public String doinsert(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("phone") String phone,
			@RequestParam("email") String email, @RequestParam("date") String date) {

		User user = new User(username, password, name, sex, phone, email, date);
		userService.insertUser(user);
		return "redirect:/adduser";
	}

	@RequestMapping("/user")
	@ResponseBody
	public String userList(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize,
			HttpServletRequest request) {
		String userString = request.getParameter("keyword");

		if (userService.selectByName(userString) != null) {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<User> userList = new ArrayList<User>();
			userList.add(userService.selectByName(userString));
			PageInfo<User> pageInfo = new PageInfo<>(userList);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", userList);
			return map.toString();
		} else {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<User> userList = userService.selectAllUser(pageNum, pageSize);
			PageInfo<User> pageInfo = new PageInfo<>(userList);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", userList);
			return map.toString();
		}

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public String deleteByName(@RequestParam("username") String username) {

		userService.deleteByName(username);

		return "200";
	}
}
