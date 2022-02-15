package com.iapl.robot.apocalypse;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.iapl.robot.apocalypse.jpa.SurvivorRepository;
import com.iapl.robot.apocalypse.model.Survivor;

@Configuration
class PreloadSurvivors {
	private static final Logger log = LoggerFactory.getLogger(PreloadSurvivors.class);

	
	@Bean
	CommandLineRunner initSurvivors(SurvivorRepository repository) {
		return args -> {
			 List<String> res = Arrays.asList("Food", "Medication", "Ammunition", "Water");
			 Survivor surv = new Survivor("Luke","Ityav","40","Male","674849","683939", res );
		    log.info("Preloading " + repository.save(surv));
		};
		
	}
}
