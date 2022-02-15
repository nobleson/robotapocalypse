package com.iapl.robot.apocalypse.util;


public class ContaminationNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ContaminationNotFoundException(Long id) {
		    super("Oops! could not find contamination with this ID: " + id);
		  }
}
