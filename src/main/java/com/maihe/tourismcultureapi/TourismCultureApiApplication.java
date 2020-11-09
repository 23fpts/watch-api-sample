package com.maihe.tourismcultureapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.maihe.tourismcultureapi.mapper")
public class TourismCultureApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourismCultureApiApplication.class, args);
	}

}
