package com.civila.config;

import com.civila.controllers.Actions;
import com.civila.controllers.Resources;
import com.civila.dao.CiviblockDao;
import com.civila.services.asserts.CiviblockAsserts;
import com.civila.services.asserts.NavigationAsserts;
import com.civila.services.api.CiviblockService;
import com.civila.services.api.NavigationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {
	@Bean public CiviblockService civiblockService() {
		return new CiviblockService(civiblockDao());
	}

	@Bean public CiviblockDao civiblockDao() {
		return new CiviblockDao();
	}

	@Bean public Resources resources (){
		return new Resources(civiblockService());
	}

	@Bean public Actions actions (){
		return new Actions (navigationService());
	}

	@Bean public NavigationService navigationService() {
		return new NavigationService(navigationServiceAsserts());
	}

	@Bean public NavigationAsserts navigationServiceAsserts() {
		return new NavigationAsserts(civiblockAsserts());
	}

	@Bean public CiviblockAsserts civiblockAsserts() {
		return new CiviblockAsserts(civiblockService());
	}
}
