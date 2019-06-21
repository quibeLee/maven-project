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
import com.hotel.model.UserOrder;
import com.hotel.service.RoomService;
import com.hotel.service.UserOrderService;

import net.sf.json.JSONObject;

/**
 * 用户订单的增删改查
 * 
 * @author liheng
 *
 */
@Controller
public class UserOrderCRUDControllor {
	@Autowired
	private UserOrderService userOrderService;
	@Autowired
	private RoomService roomService;

//订单列表
	@RequestMapping("/order")
	@ResponseBody
	public String orderList(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize,
			HttpServletRequest request) {

		String usernameString = request.getParameter("keyword");
//搜索
		if (userOrderService.selectByusername(usernameString) != null) {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<UserOrder> orderlist = new ArrayList<UserOrder>();
			orderlist.add(userOrderService.selectByusername(usernameString));
			PageInfo<UserOrder> pageInfo = new PageInfo<>(orderlist);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", orderlist);
			return map.toString();
		} else {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<UserOrder> orderList = userOrderService.selectAllOrder(0, pageNum, pageSize);
			PageInfo<UserOrder> pageInfo = new PageInfo<>(orderList);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", orderList);
			return map.toString();
		}

	}

//住房列表
	@RequestMapping("/live")
	@ResponseBody
	public String liveList(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize,
			HttpServletRequest request) {

		String usernameString = request.getParameter("keyword");

		if (userOrderService.selectByusername(usernameString) != null) {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<UserOrder> orderlist = new ArrayList<UserOrder>();
			orderlist.add(userOrderService.selectByusername(usernameString));
			PageInfo<UserOrder> pageInfo = new PageInfo<>(orderlist);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", orderlist);
			return map.toString();
		} else {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<UserOrder> orderList = userOrderService.selectAllOrder(1, pageNum, pageSize);
			PageInfo<UserOrder> pageInfo = new PageInfo<>(orderList);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", orderList);
			return map.toString();
		}

	}

//审核订单并确认入住
	@RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
	@ResponseBody
	public String updateOrder(@RequestParam("roomId") Integer roomId) {

		userOrderService.updateStatus(roomId, 1);
		roomService.updateIsnull(roomId, 1);
		return "200";
	}

//退房并删除订单
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
	@ResponseBody
	public String deleteById(@RequestParam("roomId") Integer roomId) {

		userOrderService.deleteOrder(roomId);
		roomService.updateIsnull(roomId, 0);

		return "200";
	}
}
