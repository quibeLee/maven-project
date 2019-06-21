package com.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hotel.model.Admin;

/**
 * 管理员的dao层
 * 
 * @author liheng
 *
 */
@Mapper
@Repository
public interface AdminDao {
	public Admin login(String username, String password);

	public Admin selectByName(String username);

	public List<Admin> selectAll();

	public void insert(Admin admin);

	public void updatePassword(String username, String password);

	public void updateInfo(Admin admin);

	public void deleteByName(String username);

	public int selectAllCount();

}
