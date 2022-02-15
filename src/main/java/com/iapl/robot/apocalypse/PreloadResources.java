package com.iapl.robot.apocalypse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iapl.robot.apocalypse.jpa.ResourceRepository;
import com.iapl.robot.apocalypse.model.Resource;

@Configuration
class PreloadResources {
	private static final Logger log = LoggerFactory.getLogger(PreloadResources.class);
	
	@Bean
	CommandLineRunner initResources(ResourceRepository repository) {
		return args -> {
		      log.info("Preloading " + repository.save(new Resource("Water")));
		      log.info("Preloading " + repository.save(new Resource("Food")));
		      log.info("Preloading " + repository.save(new Resource("Medication")));
		      log.info("Preloading " + repository.save(new Resource("Ammunition")));
		};
		
	}
}
