package com.senai.pets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.pets.entities.Pet;
import com.senai.pets.repositories.PetRepository;

@Service
public class PetService {
  @Autowired
  private PetRepository repository;

  public Pet create(Pet pet) {
    Pet petCriado = repository.save(pet);
    return petCriado;
  }

  public Pet read(Long id) {
    Pet petRetornado = repository.findById(id).get();
    return petRetornado;
  }

  public List<Pet> list() {
    List<Pet> pets = (List<Pet>) repository.findAll();
    return pets;
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public Pet update(Pet pet) {
    return repository.save(pet);
  }
}
