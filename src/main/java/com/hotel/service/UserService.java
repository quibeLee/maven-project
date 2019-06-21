package com.hotel.service;

import java.util.List;

import com.hotel.model.User;

/**
 * 用户模块的业务逻辑
 * 
 * @author liheng
 *
 */
public interface UserService {

	public void insertUser(User user);

	public List<User> selectAllUser(Integer page, Integer limit);

	public User selectByName(String name);

	public void deleteByName(String username);

	public int selectAllCount();

}
