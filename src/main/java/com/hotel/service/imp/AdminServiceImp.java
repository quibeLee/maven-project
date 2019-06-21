package com.hotel.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.AdminDao;
import com.hotel.model.Admin;
import com.hotel.service.AdminService;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public int selectAllCount() {

		return adminDao.selectAllCount();
	}

	@Override
	public List<Admin> selectAll(Integer page, Integer limit) {
		List<Admin> userList = adminDao.selectAll();
		return userList;
	}

	public Admin dologin(Admin admin) {

		return adminDao.login(admin.getUsername(), admin.getPassword());
	}

	@Override
	public Admin selectByName(String username) {

		return adminDao.selectByName(username);
	}

	@Override
	public List<Admin> selectAll() {

		return new ArrayList<Admin>(adminDao.selectAll());
	}

	@Override
	public void insert(Admin admin) {
		adminDao.insert(admin);
	}

	@Override
	public void updatePassword(String username, String password) {
		adminDao.updatePassword(username, password);

	}

	@Override
	public void updateInfo(Admin admin) {
		adminDao.updateInfo(admin);

	}

	@Override
	public void deleteByName(String username) {
		adminDao.deleteByName(username);
	}
}
