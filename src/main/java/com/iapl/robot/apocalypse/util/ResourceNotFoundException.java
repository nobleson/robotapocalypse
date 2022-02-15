package com.iapl.robot.apocalypse.util;


public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		    super("Oops! could not find resource with this ID: " + id);
		  }
}
