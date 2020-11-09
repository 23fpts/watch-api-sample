package com.maihe.tourismcultureapi.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.maihe.tourismcultureapi.model.Admin;

/**
 * @Author 姜立
 * 
 * @Description:实现公共字段写入
 * 
 * @CreateTime:2019/12/20
 *
 */
@Component
public class MetaHandler implements MetaObjectHandler {

	@Autowired
	private HttpServletRequest request;

	@Override
	public void insertFill(MetaObject metaObject) {
		// TODO Auto-generated method stub
		Object object = request.getAttribute("currentUser");
		Admin admin = (Admin) object;
		this.setFieldValByName("createUser", admin.getUsername(), metaObject);
		this.setFieldValByName("createTime", new Date(), metaObject);
		this.setFieldValByName("deleteFlag", "1", metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		// TODO Auto-generated method stub

	}

}
