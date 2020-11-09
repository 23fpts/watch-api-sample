package com.maihe.tourismcultureapi.intecptor;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.maihe.tourismcultureapi.resolver.CurrentUserArgumentResolver;


/**
 * @Author 姜立
 * 
 * @Description:拦截器配置
 * 
 * @CreateTime:2019/12/20
 *
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

	@Bean
	public AreaInterceptor getAreaInterceptor() {
		return new AreaInterceptor();
	}

	@Bean
	public WebTokenInterceptor getWebTokenInterceptor() {
		return new WebTokenInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 处理浏览器跨域访问拦截器
		registry.addInterceptor(getAreaInterceptor()).addPathPatterns("/**");
		// 管理端Token验证拦截器
		registry.addInterceptor(getWebTokenInterceptor()).addPathPatterns("/api/v1/**")
				.excludePathPatterns("/api/v1/login/login");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(currentUserArgumentResolver());
	}

	@Bean
	public CurrentUserArgumentResolver currentUserArgumentResolver() {
		return new CurrentUserArgumentResolver();
	}
}