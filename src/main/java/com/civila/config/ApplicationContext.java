package com.civila.config;

import com.civila.dao.CiviblockDao;
import com.civila.services.CiviblockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.civila.controllers"})
public class ApplicationContext {
	@Bean public CiviblockService civiblockService() {
		return new CiviblockService(civiblockDao());
	}

	@Bean public CiviblockDao civiblockDao() {
		return new CiviblockDao();
	}
}
