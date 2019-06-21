package com.hotel.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.RoomDao;
import com.hotel.model.Room;
import com.hotel.service.RoomService;

@Service
public class RoomServiceImp implements RoomService {

	@Autowired
	private RoomDao roomDao;

	@Override
	public void updateIsnull(Integer id, Integer isnull) {
		roomDao.updateIsnull(id, isnull);

	}

	@Override
	public int selectAllCount() {

		return roomDao.selectAllCount();
	}

	@Override
	public int selectAllLastCount() {

		return roomDao.selectAllLastCount();
	}

	@Override
	public void insertRoom(Room room) {
		roomDao.insertRoom(room);
	}

	@Override
	public List<Room> selectAllRoom(Integer page, Integer limit) {
		List<Room> roomList = roomDao.selectAllRoom();
		return roomList;
	}

	@Override
	public Room selectById(Integer id) {

		return roomDao.selectById(id);
	}

	@Override
	public void deleteById(Integer id) {
		roomDao.deleteById(id);

	}

}
