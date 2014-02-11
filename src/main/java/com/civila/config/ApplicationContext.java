package com.civila.config;

import com.civila.services.GridService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.civila.controllers"})
public class ApplicationContext {
	@Bean public GridService gridService (){
		return new GridService();
	}
}
