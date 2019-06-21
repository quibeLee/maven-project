package com.hotel.controller;

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
import com.hotel.model.Food;
import com.hotel.service.FoodService;

import net.sf.json.JSONObject;

/**
 * 餐饮模块的增删改查
 * 
 * @author liheng
 *
 */
@Controller
public class FoodCRUDControllor {
	@Autowired
	private FoodService foodService;

	@RequestMapping("foodinsert")
	public String foodinsert(@RequestParam("name") String name, @RequestParam("info") String info,
			@RequestParam("price") Integer price) {
		Food food = new Food(name, info, price);
		foodService.insertFood(food);
		return "redirect:/addfood";
	}

	@RequestMapping("/food")
	@ResponseBody
	public String foodList(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize,
			HttpServletRequest request) {

		JSONObject map = new JSONObject();
		PageHelper.startPage(pageNum, pageSize);
		List<Food> foodList = foodService.selectAllFood(pageNum, pageSize);
		PageInfo<Food> pageInfo = new PageInfo<>(foodList);
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageInfo.getTotal());
		map.put("data", foodList);
		return map.toString();

	}

	@RequestMapping(value = "/deleteFood", method = RequestMethod.POST)
	@ResponseBody
	public String deleteByName(@RequestParam("name") String name) {

		foodService.deleteByName(name);

		return "200";
	}

}
