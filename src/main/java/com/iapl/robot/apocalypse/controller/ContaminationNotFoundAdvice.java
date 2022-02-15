package com.iapl.robot.apocalypse.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iapl.robot.apocalypse.util.ContaminationNotFoundException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
class ContaminationNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ContaminationNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String contaminationNotFoundHandler(ContaminationNotFoundException ex) {
    return ex.getMessage();
  }
}


