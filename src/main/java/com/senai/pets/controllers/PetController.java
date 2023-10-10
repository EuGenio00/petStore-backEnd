package com.senai.pets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.pets.entities.Pet;
import com.senai.pets.services.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
  @Autowired
  private PetService service;

  @PostMapping
  public ResponseEntity<Pet> post(@RequestBody Pet pet) {
    Pet petCriado = service.create(pet);
    return new ResponseEntity<Pet>(petCriado, HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<Pet> put(@RequestBody Pet pet) {
    Pet petAtualizado = service.update(pet);
    return ResponseEntity.ok(petAtualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping

  public ResponseEntity<List<Pet>> getList() {
    List<Pet> lista = service.list();
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pet> getRead(@PathVariable Long id) {
    Pet petEncontrado = service.read(id);
    return ResponseEntity.ok(petEncontrado);
  }
}
