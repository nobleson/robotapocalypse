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

import com.iapl.robot.apocalypse.jpa.ContaminationRepository;
import com.iapl.robot.apocalypse.model.Contamination;
import com.iapl.robot.apocalypse.model.ContaminationModelAssembler;
import com.iapl.robot.apocalypse.util.ContaminationNotFoundException;

@CrossOrigin(origins = "http://localhost:4000", maxAge = 3600)
@RestController
public class  ContaminationController {

  private final ContaminationRepository repository;
  private final ContaminationModelAssembler assembler;

  ContaminationController(ContaminationRepository repository, ContaminationModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  
  
  // Aggregate root
  // end::get-aggregate-root[]
  
  @GetMapping("/contaminations")
  public CollectionModel<EntityModel<Contamination>> all() {

    List<EntityModel<Contamination>> contamination = repository.findAll().stream() //
        .map(assembler::toModel) //
        .collect(Collectors.toList());

    return CollectionModel.of(contamination, linkTo(methodOn(ContaminationController.class).all()).withSelfRel());
  }  

  // Single item
  @GetMapping("/contamination/{id}")
  public EntityModel<Contamination> one(@PathVariable Long id) {

	  Contamination contamination = repository.findById(id) //
        .orElseThrow(() -> new ContaminationNotFoundException(id));

    return assembler.toModel(contamination);
  }
  
  @PostMapping("/contamination")
  ResponseEntity<?> newContamination(@RequestBody Contamination newContamination) {

    EntityModel<Contamination> entityModel = assembler.toModel(repository.save(newContamination));

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  
  @DeleteMapping("/contamination/{id}")
  ResponseEntity<?> deleteContamination(@PathVariable Long id) {

    repository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}