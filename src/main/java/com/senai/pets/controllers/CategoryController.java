package com.senai.pets.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.senai.pets.entities.Category;
import com.senai.pets.services.CategoryService;

public class CategoryController {
  private CategoryService service;

  public Category post(@RequestBody Category category) {
    Category categoriaCriada = service.create(category);
    return categoriaCriada;
  }

  public Category put(@RequestBody Category category) {
    Category categoriaAtualizada = service.update(category);
    return categoriaAtualizada;
  }

  public void delete(Long id) {
    service.delete(id);
  }

  public List<Category> getList() {
    List<Category> lista = service.list();
    return lista;
  }

  public Category getRead(Long id) {
    Category categoriaEncontrada = service.read(id);
    return categoriaEncontrada;
  }
}
