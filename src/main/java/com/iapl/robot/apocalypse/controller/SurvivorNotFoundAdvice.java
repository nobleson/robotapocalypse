package com.iapl.robot.apocalypse.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.iapl.robot.apocalypse.util.SurvivorNotFoundException;

import org.springframework.http.HttpStatus;

@ControllerAdvice
class SurvivorNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(SurvivorNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String survivorNotFoundHandler(SurvivorNotFoundException ex) {
    return ex.getMessage();
  }
}