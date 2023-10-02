package com.senai.pets.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator extends User {
  private boolean isAdmin;
  private Office office;
}
