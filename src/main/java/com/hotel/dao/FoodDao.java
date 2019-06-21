package com.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hotel.model.Food;

/**
 * 餐饮dao层
 * 
 * @author liheng
 *
 */
@Mapper
@Repository
public interface FoodDao {
	public void insertFood(Food food);

	public List<Food> selectAllFood();

	public Food selectByName(String name);

	public void deleteByName(String name);
}
