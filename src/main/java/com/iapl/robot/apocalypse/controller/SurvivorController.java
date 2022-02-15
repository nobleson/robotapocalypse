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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iapl.robot.apocalypse.jpa.SurvivorRepository;
import com.iapl.robot.apocalypse.model.Survivor;
import com.iapl.robot.apocalypse.model.SurvivorModelAssembler;
import com.iapl.robot.apocalypse.util.SurvivorNotFoundException;

@CrossOrigin(origins = "http://localhost:4000", maxAge = 3600)
@RestController
public class SurvivorController {

  private final SurvivorRepository repository;
  private final SurvivorModelAssembler assembler;

  SurvivorController(SurvivorRepository repository, SurvivorModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  
  
  // Aggregate root
  // end::get-aggregate-root[]
  
  @GetMapping("/survivors")
  public CollectionModel<EntityModel<Survivor>> all() {

    List<EntityModel<Survivor>> survivor = repository.findAll().stream() //
        .map(assembler::toModel) //
        .collect(Collectors.toList());

    return CollectionModel.of(survivor, linkTo(methodOn(SurvivorController.class).all()).withSelfRel());
  }  

  // Single item
  @GetMapping("/survivor/{id}")
  public EntityModel<Survivor> one(@PathVariable Long id) {

	  Survivor survivor = repository.findById(id) //
        .orElseThrow(() -> new SurvivorNotFoundException(id));

    return assembler.toModel(survivor);
  }
  
  @PostMapping("/survivor")
  ResponseEntity<?> newSurvivor(@RequestBody Survivor newSurvivor) {

    EntityModel<Survivor> entityModel = assembler.toModel(repository.save(newSurvivor));

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  
  @PutMapping("/survivor/{id}")
  ResponseEntity<?> replaceSurvivor(@RequestBody Survivor newSurvivor, @PathVariable Long id) {

	  Survivor updatedSurvivor = repository.findById(id) //
        .map(survivor -> {
        	survivor.setLastLocationLatitude(newSurvivor.getLastLocationLatitude());
        	survivor.setLastLocationLongitude(newSurvivor.getLastLocationLongitude());
        	survivor.setSurvivorStatus(newSurvivor.getSurvivorStatus());
          return repository.save(survivor);
        }) //
        .orElseGet(() -> {
        	newSurvivor.setId(id);
          return repository.save(newSurvivor);
        });

    EntityModel<Survivor> entityModel = assembler.toModel(updatedSurvivor);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }
  
  @DeleteMapping("/survivor/{id}")
  ResponseEntity<?> deleteSurvivor(@PathVariable Long id) {

    repository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}