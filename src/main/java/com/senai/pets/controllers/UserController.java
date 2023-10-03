package com.senai.pets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.pets.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService service;

}
