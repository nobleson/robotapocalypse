package com.iapl.robot.apocalypse.model;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.iapl.robot.apocalypse.controller.SurvivorController;

@Component
public class SurvivorModelAssembler implements RepresentationModelAssembler<Survivor, EntityModel<Survivor>> {

  @Override
  public EntityModel<Survivor> toModel(Survivor survivor) {

    return EntityModel.of(survivor, //
        linkTo(methodOn(SurvivorController.class).one(survivor.getId())).withSelfRel(),
        linkTo(methodOn(SurvivorController.class).all()).withRel("survivors"));
  }
}