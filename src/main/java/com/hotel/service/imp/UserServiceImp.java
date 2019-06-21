package com.hotel.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.UserDao;
import com.hotel.model.User;
import com.hotel.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int selectAllCount() {

		return userDao.selectAllCount();
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);

	}

	@Override
	public User selectByName(String name) {

		return userDao.selectByName(name);
	}

	@Override
	public void deleteByName(String username) {
		userDao.deleteByName(username);

	}

	@Override
	public List<User> selectAllUser(Integer page, Integer limit) {
		List<User> userList = userDao.selectAllUser();
		return userList;
	}

}
