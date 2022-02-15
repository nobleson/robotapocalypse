package com.iapl.robot.apocalypse.model;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.iapl.robot.apocalypse.controller.ContaminationController;

@Component
public class ContaminationModelAssembler implements RepresentationModelAssembler<Contamination, EntityModel<Contamination>> {

  @Override
  public EntityModel<Contamination> toModel(Contamination contamination) {

    return EntityModel.of(contamination, //
        linkTo(methodOn(ContaminationController.class).one(contamination.getId())).withSelfRel(),
        linkTo(methodOn(ContaminationController.class).all()).withRel("contamination"));
  }
}