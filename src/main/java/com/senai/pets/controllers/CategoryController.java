package com.senai.pets.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.senai.pets.entities.Category;
import com.senai.pets.services.CategoryService;

public class CategoryController {
  private CategoryService service;

  public ResponseEntity<Category> post(@RequestBody Category category) {
    Category categoriaCriada = service.create(category);
    return new ResponseEntity<Category>(categoriaCriada, HttpStatus.CREATED);
  }

  public ResponseEntity<Category> put(@RequestBody Category category) {
    Category categoriaAtualizada = service.update(category);
    return ResponseEntity.ok(categoriaAtualizada);
  }

  public ResponseEntity delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  public ResponseEntity<List<Category>> getList() {
    List<Category> lista = service.list();
    return ResponseEntity.ok(lista);
  }

  public ResponseEntity<Category> getRead(@PathVariable Long id) {
    Category categoriaEncontrada = service.read(id);
    return ResponseEntity.ok(categoriaEncontrada);
  }
}
