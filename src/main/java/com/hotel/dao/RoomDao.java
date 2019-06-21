package com.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hotel.model.Room;

/**
 * 房间dao层
 * 
 * @author liheng
 *
 */
@Mapper
@Repository
public interface RoomDao {
	public void insertRoom(Room room);

	public List<Room> selectAllRoom();

	public Room selectById(Integer id);

	public void deleteById(Integer id);

	public void updateIsnull(Integer id, Integer isnull);

	public int selectAllCount();

	public int selectAllLastCount();
}
