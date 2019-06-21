package com.hotel.model;

public class UserOrder {
	private Integer id;
	private String username;
	private Integer roomid;
	private String status;
	private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRoomId() {
		return roomid;
	}

	public void setRoomId(Integer roomid) {
		this.roomid = roomid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @param username
	 * @param roomId
	 * @param status
	 * @param time
	 */
	public UserOrder(String username, Integer roomid, String status, String time) {
		super();
		this.username = username;
		this.roomid = roomid;
		this.status = status;
		this.time = time;
	}

	/**
	 * 
	 */
	public UserOrder() {
		super();
	}

}
