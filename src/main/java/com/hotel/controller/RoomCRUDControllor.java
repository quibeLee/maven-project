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
import com.hotel.model.Room;
import com.hotel.service.RoomService;

import net.sf.json.JSONObject;

/**
 * 房间模块的增删改查
 * 
 * @author liheng
 *
 */
@Controller
public class RoomCRUDControllor {
	@Autowired
	private RoomService roomService;

	@RequestMapping("roominsert")
	public String roominsert(@RequestParam("roomid") Integer id, @RequestParam("type") String type,
			@RequestParam("price") Integer price, @RequestParam("isnull") Integer isnull) {
		Room room = new Room(id, type, price, isnull);
		roomService.insertRoom(room);

		return "redirect:/addroom";
	}

	@RequestMapping("/room")
	@ResponseBody
	public String roomList(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize,
			HttpServletRequest request) {
		Integer roomid = request.getParameter("keyword") != null && !request.getParameter("keyword").equals("")
				? Integer.parseInt(request.getParameter("keyword"))
				: null;
		if (roomService.selectById(roomid) != null) {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<Room> roomList = new ArrayList<Room>();
			roomList.add(roomService.selectById(roomid));
			PageInfo<Room> pageInfo = new PageInfo<>(roomList);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", roomList);
			return map.toString();
		} else {
			JSONObject map = new JSONObject();
			PageHelper.startPage(pageNum, pageSize);
			List<Room> roomList = roomService.selectAllRoom(pageNum, pageSize);
			PageInfo<Room> pageInfo = new PageInfo<>(roomList);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", pageInfo.getTotal());
			map.put("data", roomList);
			return map.toString();
		}

	}

	@RequestMapping(value = "/deleteRoom", method = RequestMethod.POST)
	@ResponseBody
	public String deleteById(@RequestParam("roomid") Integer id) {

		roomService.deleteById(id);

		return "200";
	}

//根据房间号判断房间是否被使用
	@RequestMapping("isadd")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		Integer roomid = request.getParameter("name") != null && !request.getParameter("name").equals("")
				? Integer.parseInt(request.getParameter("name"))
				: null;
		Room room = roomService.selectById(roomid);

		// 判断房间是否已被使用
		if (room != null) {
			pw.print(true);
		} else {
			pw.print(false);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
