package com.senai.pets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.pets.repositories.OrderRepository;

@Service
public class OrderService {
  @Autowired
  private OrderRepository repository;

  @Transactional
  public User create(User user) {
    User userCriado = repository.save(user);
    return userCriado;
  }

  @Transactional
  public User read(Long id) {
    User userRetornado = repository.findById(id).get();
    return userRetornado;
  }

  @Transactional
  public List<User> list() {
    List<User> users = (List<User>) repository.findAll();
    return users;
  }

  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Transactional
  public User update(User user) {
    if (repository.existsById(user.getId())) {
      return repository.save(user);
    } else {
      return null;
    }
  }
}
