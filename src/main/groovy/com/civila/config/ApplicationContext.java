package com.civila.config;

import com.civila.aux.assertion.AssertionRunner;
import com.civila.controllers.Actions;
import com.civila.controllers.Resources;
import com.civila.dao.CiviblockDao;
import com.civila.services.internal.*;
import com.civila.services.secure.SecureCiviblockService;
import com.civila.services.secure.SecureCommandsService;
import com.civila.services.secure.SecureNavigationService;
import com.civila.services.secure.SecureTurnService;
import com.civila.services.secure.asserts.CiviblockAsserts;
import com.civila.services.secure.asserts.NavigationAsserts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {
	@Bean public InternalCiviblockService internalCiviblockService(CiviblockDao civiblockDao) {
		return new InternalCiviblockService(civiblockDao);
	}

	@Bean public CiviblockDao civiblockDao(DataInitialiser dataInitialiser) {
		return new CiviblockDao(dataInitialiser.initialiseData());
	}

	@Bean public DataInitialiser dataInitialiser(CityFactory cityFactory) {
		return new DataInitialiser(cityFactory);
	}

	@Bean public CityFactory cityFactory (){
		return new CityFactory();
	}

	@Bean public Resources resources(SecureCiviblockService secureCiviblockService, SecureTurnService secureTurnService){
		return new Resources(secureCiviblockService, secureTurnService);
	}

	@Bean public SecureTurnService secureTurnService() {
		return new SecureTurnService();
	}

	@Bean public SecureCiviblockService secureCiviblockService(InternalCiviblockService internalCiviblockService) {
		return new SecureCiviblockService(internalCiviblockService);
	}

	@Bean public Actions actions(SecureCommandsService commandsService){
		return new Actions (commandsService);
	}

	@Bean public SecureCommandsService secureCommandsService(SecureNavigationService secureNavigationService) {
		return new SecureCommandsService(secureNavigationService);
	}

	@Bean public SecureNavigationService secureNavigationService(InternalNavigationService internalNavigationService, NavigationAsserts navigationAsserts) {
		return new SecureNavigationService(internalNavigationService, navigationAsserts);
	}

	@Bean public InternalNavigationService internalNavigationService(WorldCreator worldCreator, InternalCiviblockService internalCiviblockService) {
		return new InternalNavigationService(worldCreator, internalCiviblockService);
	}

	@Bean public WorldCreator worldCreator() {
		return new WorldCreator();
	}

	@Bean public NavigationAsserts navigationServiceAsserts(CiviblockAsserts civiblockAsserts, AssertionRunner assertionRunner) {
		return new NavigationAsserts(civiblockAsserts, assertionRunner);
	}

	@Bean public CiviblockAsserts civiblockAsserts(InternalCiviblockService internalCiviblockService, AssertionRunner assertionRunner) {
		return new CiviblockAsserts(internalCiviblockService, assertionRunner);
	}

	@Bean public AssertionRunner assertionRunner() {
		return new AssertionRunner();
	}
}
