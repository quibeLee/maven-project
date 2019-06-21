package com.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hotel.model.User;

/**
 * 用户dao层
 * 
 * @author liheng
 *
 */
@Mapper
@Repository
public interface UserDao {
	public void insertUser(User user);

	public List<User> selectAllUser();

	public User selectByName(String name);

	public void deleteByName(String username);

	public int selectAllCount();
}
