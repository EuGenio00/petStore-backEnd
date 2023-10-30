package com.senai.pets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.pets.dtos.PetInputDTO;
import com.senai.pets.dtos.PetOutputDTO;
import com.senai.pets.entities.Pet;
import com.senai.pets.repositories.PetRepository;

import jakarta.transaction.Transactional;

@Service
public class PetService {
  @Autowired
  private PetRepository repository;

  @Transactional
  public PetOutputDTO create(PetInputDTO dto) {
    Pet pet = new Pet();
    pet.setName(dto.getName());
    pet.setStatus(dto.getStatus());

    Pet petCriado = repository.save(pet);

    return convertePetOutput(petCriado);
  }

  public PetOutputDTO convertePetOutput(Pet pet) {
    PetOutputDTO petSaida = new PetOutputDTO(pet.getId(), pet.getName(), pet.getStatus());
    return petSaida;
  }

  public Pet read(Long id) {
    Pet petRetornado = repository.findById(id).get();
    return petRetornado;
  }

  public List<Pet> list() {
    List<Pet> pets = (List<Pet>) repository.findAll();
    return pets;
  }

  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Transactional
  public Pet update(Pet pet) {
    if (repository.existsById(pet.getId())) {
      return repository.save(pet);
    } else {
      return null;
    }
  }
}
