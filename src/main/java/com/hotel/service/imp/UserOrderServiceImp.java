package com.hotel.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.OrderDao;
import com.hotel.model.UserOrder;
import com.hotel.service.UserOrderService;

@Service
public class UserOrderServiceImp implements UserOrderService {

	@Autowired
	private OrderDao userOrderDao;

	@Override
	public UserOrder selectByusername(String username) {

		return userOrderDao.selectByusername(username);
	}

	@Override
	public List<UserOrder> selectAllOrder(Integer status, Integer page, Integer limit) {
		List<UserOrder> orders = userOrderDao.selectAllOrder(status);
		return orders;
	}

	@Override
	public void updateStatus(Integer roomId, Integer status) {
		userOrderDao.updateStatus(roomId, status);
	}

	@Override
	public void deleteOrder(Integer roomId) {
		userOrderDao.deleteOrder(roomId);

	}

}
