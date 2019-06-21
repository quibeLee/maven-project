package com.hotel.model;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String date;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param name
	 * @param sex
	 * @param phone
	 * @param email
	 * @param date
	 */
	public User(String username, String password, String name, String sex, String phone, String email, String date) {
		super();

		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.date = date;
	}

}
