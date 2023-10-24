package com.senai.pets.dtos;

import com.senai.pets.entities.Status;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetOutputDTO {
  private Long id;
  private String name;
  private Status status;
}
