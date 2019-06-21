package com.hotel.model;

public class Admin {
	private Integer id;

	private String username;
	private String password;
	private String phone;
	private String email;
	private String sex;

	/**
	 * @param username
	 * @param password
	 * @param phone
	 * @param email
	 * @param sex
	 */
	public Admin(String username, String password, String phone, String email, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.sex = sex;
	}

	/**
	 * 
	 */
	public Admin() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

}
