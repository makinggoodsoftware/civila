package com.civila.config;

import com.civila.controllers.Actions;
import com.civila.controllers.Resources;
import com.civila.dao.CiviblockDao;
import com.civila.aux.assertion.AssertionRunner;
import com.civila.model.*;
import com.civila.services.internal.WorldCreator;
import com.civila.services.secure.SecureCiviblockService;
import com.civila.services.secure.SecureNavigationService;
import com.civila.services.secure.asserts.CiviblockAsserts;
import com.civila.services.secure.asserts.NavigationAsserts;
import com.civila.services.internal.InternalCiviblockService;
import com.civila.services.internal.InternalNavigationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationContext {
	@Bean public InternalCiviblockService internalCiviblockService() {
		return new InternalCiviblockService(civiblockDao());
	}

	@Bean public CiviblockDao civiblockDao() {
		Map<Coordinates, Civiblock> data = new HashMap<>();
		Coordinates initialLocation = new Coordinates(0, 0);
		data.put(
				initialLocation,
				new Civiblock(CiviblockStates.OCCUPIED, new Territory(TerritoryType.FARMS), new Persona("Jon doe"), initialLocation)
		);
		return new CiviblockDao(data);
	}

	@Bean public Resources resources (){
		return new Resources(secureCiviblockService());
	}

	@Bean public SecureCiviblockService secureCiviblockService() {
		return new SecureCiviblockService(internalCiviblockService());
	}

	@Bean public Actions actions (){
		return new Actions (secureNavigationService());
	}

	@Bean public SecureNavigationService secureNavigationService() {
		return new SecureNavigationService(internalNavigationService(), navigationServiceAsserts());
	}

	@Bean public InternalNavigationService internalNavigationService() {
		return new InternalNavigationService(worldCreator(), internalCiviblockService());
	}

	private WorldCreator worldCreator() {
		return new WorldCreator();
	}

	@Bean public NavigationAsserts navigationServiceAsserts() {
		return new NavigationAsserts(civiblockAsserts(), assertionRunner());
	}

	@Bean public CiviblockAsserts civiblockAsserts() {
		return new CiviblockAsserts(internalCiviblockService(), assertionRunner());
	}

	@Bean public AssertionRunner assertionRunner() {
		return new AssertionRunner();
	}
}
