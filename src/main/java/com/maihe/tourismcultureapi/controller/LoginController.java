package com.maihe.tourismcultureapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maihe.tourismcultureapi.response.JsonData;
import com.maihe.tourismcultureapi.service.LoginService;

/**
 * @Author 姜立
 * 
 * @Description:
 * 
 * @CreateTime:2020/4/20
 *
 */
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 功能描述：登录
	 * 
	 * @param
	 * @return
	 */
	@PostMapping(value = "login")
	public Object login(@RequestParam String username, @RequestParam String password) {
		return JsonData.buildSuccess(loginService.login(username, password));
	}
}
