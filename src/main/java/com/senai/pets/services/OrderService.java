package com.senai.pets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.pets.entities.Order;
import com.senai.pets.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
  @Autowired
  private OrderRepository repository;

  @Transactional
  public Order create(Order order) {
    Order orderCriado = repository.save(order);
    return orderCriado;
  }

  @Transactional
  public Order read(Long id) {
    Order orderRetornado = repository.findById(id).get();
    return orderRetornado;
  }

  @Transactional
  public List<Order> list() {
    List<Order> orders = (List<Order>) repository.findAll();
    return orders;
  }

  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Transactional
  public Order update(Order order) {
    if (repository.existsById(order.getId())) {
      return repository.save(order);
    } else {
      return null;
    }
  }
}
