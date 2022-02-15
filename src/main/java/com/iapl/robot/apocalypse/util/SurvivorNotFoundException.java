package com.iapl.robot.apocalypse.util;


public class SurvivorNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public SurvivorNotFoundException(Long id) {
		    super("Oops! could not find survivor with this ID: " + id);
		  }
}
