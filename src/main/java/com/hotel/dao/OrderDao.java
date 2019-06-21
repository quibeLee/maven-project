package com.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hotel.model.UserOrder;

/**
 * 订单dao层
 * 
 * @author liheng
 *
 */
@Mapper
@Repository
public interface OrderDao {
	public List<UserOrder> selectAllOrder(Integer status);

	public void updateStatus(Integer roomid, Integer status);

	public void deleteOrder(Integer roomid);

	public UserOrder selectByusername(String username);
}
