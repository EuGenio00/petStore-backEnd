package com.senai.pets.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Address {
  private String street;
  private String number;
  private String state;
  private String city;
  private String cep;
  private String district;
  private String complement;
}
