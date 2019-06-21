package com.hotel.service;

import java.util.List;

import com.hotel.model.Food;

/**
 * 餐饮模块的业务逻辑
 * 
 * @author liheng
 *
 */
public interface FoodService {
	public void insertFood(Food food);

	public List<Food> selectAllFood(Integer page, Integer limit);

	public Food selectByName(String name);

	public void deleteByName(String name);
}
