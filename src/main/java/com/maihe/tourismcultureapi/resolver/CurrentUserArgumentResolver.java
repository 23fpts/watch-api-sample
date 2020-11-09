package com.maihe.tourismcultureapi.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.maihe.tourismcultureapi.annotation.CurrentUser;
import com.maihe.tourismcultureapi.model.Admin;

/**
 * @Author 姜立
 * 
 * @Description:自定义参数解析，获取当前登录用户
 * 
 * @CreateTime:2019/12/20
 *
 */
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return (parameter.getParameterType().isAssignableFrom(Admin.class))
				&& parameter.hasParameterAnnotation(CurrentUser.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub
		return webRequest.getAttribute("currentUser", RequestAttributes.SCOPE_REQUEST);
	}

}
