package com.senai.pets.dtos;

import com.senai.pets.entities.Status;

import lombok.AllArgsConstructor;
import lombok.Data;

// public record PetInputDTO(
//     String name,
//     Status status) {

// }

@Data
@AllArgsConstructor
public class PetInputDTO {
  private String name;
  private Status status;
}
