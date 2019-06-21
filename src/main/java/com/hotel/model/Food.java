package com.hotel.model;

public class Food {
	private Integer id;
	private String name;
	private String info;
	private Integer price;

	/**
	 * @param id
	 * @param name
	 * @param photo
	 * @param price
	 */
	public Food(String name, String info, Integer price) {
		super();
		this.name = name;
		this.info = info;
		this.price = price;
	}

	/**
	 * 
	 */
	public Food() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
