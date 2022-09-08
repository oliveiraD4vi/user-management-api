package com.management.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.api.database.UserRepository;
import com.management.api.models.User;

@RestController
@RequestMapping("/user")
public class UserController {
  
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/list")
  public List<User> listUsers() {
    return userRepository.findAll();
  }
}
