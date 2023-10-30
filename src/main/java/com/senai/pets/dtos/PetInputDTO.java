package com.senai.pets.dtos;

import com.senai.pets.entities.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

// public record PetInputDTO(
//     String name,
//     Status status) {

// }

@Data
@AllArgsConstructor
public class PetInputDTO {
  @NotBlank
  private String name;
  @NotNull
  private Status status;
}
