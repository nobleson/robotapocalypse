package com.iapl.robot.apocalypse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.iapl.robot.apocalypse.jpa.ContaminationRepository;
import com.iapl.robot.apocalypse.model.Contamination;

@Configuration
class PreloadContaminations {
	private static final Logger log = LoggerFactory.getLogger(PreloadContaminations.class);
	
	@Bean
	CommandLineRunner initContaminations(ContaminationRepository repository) {
		return args -> {
		      log.info("Preloading " + repository.save(new Contamination("1","2")));
		};
		
	}
}
