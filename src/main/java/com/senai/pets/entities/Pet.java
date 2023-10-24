package com.senai.pets.entities;

import java.util.List;

import com.senai.pets.dtos.PetInputDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Cria bd
@Data // biblioteca lombok que permite criar get, set, equal e toString
@AllArgsConstructor // importar o construtor com todos os argumentos
@NoArgsConstructor // importar o construtor vazio

// @Table(name = "pets")

public class Pet {
  public Pet(PetInputDTO dto) {
    this.name = dto.getName();
    this.status = dto.getStatus();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Enumerated(EnumType.STRING)
  private Status status;

  // @Column(unique = true, nullable = false, updatable = false, length = 98)
  private String name;
  @ManyToOne
  private Category category;

  @ManyToOne(optional = true)
  private Order order;

  @ManyToOne(optional = false)
  private Administrator createdBy;

  @ManyToMany
  private List<Tag> tags;
}
