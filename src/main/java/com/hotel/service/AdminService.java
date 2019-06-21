package com.hotel.service;

import java.util.List;

import com.hotel.model.Admin;

/**
 * 管理员模块业务逻辑
 * 
 * @author liheng
 *
 */
public interface AdminService {
	public Admin dologin(Admin Admin);

	public Admin selectByName(String username);

	public List<Admin> selectAll();

	List<Admin> selectAll(Integer page, Integer limit);

	public void insert(Admin admin);

	public void updatePassword(String username, String password);

	public void updateInfo(Admin admin);

	public void deleteByName(String username);

	public int selectAllCount();

}
