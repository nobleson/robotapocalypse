package com.iapl.robot.apocalypse.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.iapl.robot.apocalypse.jpa.ResourceRepository;
import com.iapl.robot.apocalypse.model.Resource;
import com.iapl.robot.apocalypse.model.ResourceModelAssembler;
import com.iapl.robot.apocalypse.util.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4000", maxAge = 3600)
@RestController
public class ResourceController {

  private final ResourceRepository repository;
  private final ResourceModelAssembler assembler;

  ResourceController(ResourceRepository repository, ResourceModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  
  
  // Aggregate root
  // end::get-aggregate-root[]
  
  @GetMapping("/resources")
  public CollectionModel<EntityModel<Resource>> all() {

    List<EntityModel<Resource>> resource = repository.findAll().stream() //
        .map(assembler::toModel) //
        .collect(Collectors.toList());

    return CollectionModel.of(resource, linkTo(methodOn(ResourceController.class).all()).withSelfRel());
  }  

  // Single item
  @GetMapping("/resource/{id}")
  public EntityModel<Resource> one(@PathVariable Long id) {

	  Resource resource = repository.findById(id) //
        .orElseThrow(() -> new ResourceNotFoundException(id));

    return assembler.toModel(resource);
  }
  
  @PostMapping("/resource")
  ResponseEntity<?> newResource(@RequestBody Resource newResource) {

    EntityModel<Resource> entityModel = assembler.toModel(repository.save(newResource));

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  
  @DeleteMapping("/resource/{id}")
  ResponseEntity<?> deleteResource(@PathVariable Long id) {

    repository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}