package com.maihe.tourismcultureapi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maihe.tourismcultureapi.exception.MyException;
import com.maihe.tourismcultureapi.mapper.AdminMapper;
import com.maihe.tourismcultureapi.model.Admin;
import com.maihe.tourismcultureapi.utils.RedisConstants;
import com.maihe.tourismcultureapi.utils.RedisUtil;

@Service
public class LoginService {

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private RedisUtil redisUtil;

	@Value("${spring.redis.expire}")
	private Long expire;

	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	private static String msg = "用户名或密码错误";

	public Object login(String username, String password) {
		QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("username", username);
		Admin admin = adminMapper.selectOne(queryWrapper);
		if (admin == null || !bCryptPasswordEncoder.matches(password, admin.getPassword())) {
			throw new MyException("1", msg);
		}
		String token = UUID.randomUUID().toString().replace("-", "");
		redisUtil.set(token, admin, RedisConstants.datebase2, expire);
		Map<Object, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("user", admin);
		return map;
	}
}
