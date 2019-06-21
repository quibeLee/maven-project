package com.hotel.model;

public class Room {
	private Integer id;
	private String type;
	private Integer price;
	private Integer isnull;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getIsnull() {
		return isnull;
	}

	public void setIsnull(Integer isnull) {
		this.isnull = isnull;
	}

	/**
	 * 
	 */
	public Room() {
		super();
	}

	/**
	 * @param id
	 * @param type
	 * @param price
	 * @param isnull
	 */
	public Room(Integer id, String type, Integer price, Integer isnull) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.isnull = isnull;
	}

}
