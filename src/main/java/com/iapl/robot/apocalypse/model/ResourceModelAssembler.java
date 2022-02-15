package com.iapl.robot.apocalypse.model;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.iapl.robot.apocalypse.controller.ResourceController;

@Component
public class ResourceModelAssembler implements RepresentationModelAssembler<Resource, EntityModel<Resource>> {

  @Override
  public EntityModel<Resource> toModel(Resource resource) {

    return EntityModel.of(resource, //
        linkTo(methodOn(ResourceController.class).one(resource.getId())).withSelfRel(),
        linkTo(methodOn(ResourceController.class).all()).withRel("resource"));
  }
}