package com.maihe.tourismcultureapi.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.maihe.tourismcultureapi.base.BaseModel;

@TableName("t_admin")
public class Admin extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
