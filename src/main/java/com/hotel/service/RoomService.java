package com.hotel.service;

import java.util.List;

import com.hotel.model.Room;

/**
 * 房间模块的业务逻辑
 * 
 * @author liheng
 *
 */
public interface RoomService {
	public void insertRoom(Room room);

	public List<Room> selectAllRoom(Integer page, Integer limit);

	public Room selectById(Integer id);

	public void deleteById(Integer id);

	public void updateIsnull(Integer id, Integer isnull);

	public int selectAllCount();

	public int selectAllLastCount();
}
