package com.iapl.robot.apocalypse.controller;


	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.ResponseStatus;
    import com.iapl.robot.apocalypse.util.ResourceNotFoundException;

	import org.springframework.http.HttpStatus;

	@ControllerAdvice
	class ResourceNotFoundAdvice {

	  @ResponseBody
	  @ExceptionHandler(ResourceNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String survivorNotFoundHandler(ResourceNotFoundException ex) {
	    return ex.getMessage();
	  }
	}

