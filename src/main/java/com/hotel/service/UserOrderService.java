package com.hotel.service;

import java.util.List;

import com.hotel.model.UserOrder;

/**
 * 用户订房模块的业务逻辑
 * 
 * @author liheng
 *
 */
public interface UserOrderService {
	public List<UserOrder> selectAllOrder(Integer status, Integer page, Integer limit);

	public void updateStatus(Integer roomId, Integer status);

	public void deleteOrder(Integer roomId);

	public UserOrder selectByusername(String username);
}
