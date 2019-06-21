package com.hotel.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.FoodDao;
import com.hotel.model.Food;
import com.hotel.service.FoodService;

@Service
public class FoodServiceImp implements FoodService {

	@Autowired
	private FoodDao foodDao;

	@Override
	public void insertFood(Food food) {
		foodDao.insertFood(food);

	}

	@Override
	public List<Food> selectAllFood(Integer page, Integer limit) {
		List<Food> foods = foodDao.selectAllFood();
		return foods;
	}

	@Override
	public Food selectByName(String name) {

		return foodDao.selectByName(name);
	}

	@Override
	public void deleteByName(String name) {

		foodDao.deleteByName(name);

	}

}
