package com.management.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.api.database.UserRepository;
import com.management.api.models.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
@Tag(name="API REST Users")
public class UserController {
  
  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Operation(description="Returns an User based on the Id passsed")
  @GetMapping("/user")
  public ResponseEntity<Optional<User>> user(@RequestParam long id) {
    try {
      Optional<User> user = userRepository.findById(id);

      return ResponseEntity.status(HttpStatus.OK).body(user);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @Operation(description="Deletes an User based on the Id passsed")
  @DeleteMapping("/user")
  public ResponseEntity<Boolean> deleteUser(@RequestParam long id) {
    try {
      userRepository.delete(userRepository.findById(id).get());
      
      return ResponseEntity.status(HttpStatus.OK).body(true);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }
  }

  @Operation(description="Returns an list of Users based on the identification (CPF or RG) passsed")
  @GetMapping("/search")
  public ResponseEntity<Optional<User>> searchUser(@RequestParam String identification) {
    Optional<User> findByCpf = userRepository.findByCpf(identification);
    Optional<User> findByRg = userRepository.findByRg(identification);

    if (findByCpf.isEmpty() && findByRg.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else if (!findByCpf.isEmpty()) {
      return ResponseEntity.ok(findByCpf);
    } else {
      return ResponseEntity.ok(findByRg);
    }
  }

  @Operation(description="Returns an list of Users based on the name passsed")
  @GetMapping("/search/name")
  public ResponseEntity<List<User>> searchByName(@RequestParam String name) {
    try {
      List<User> list = userRepository.findAll();
      List<User> findByName = new ArrayList<>();

      for (User user : list) {
        if (user.getName().toLowerCase().contains(name.toLowerCase())) {
          findByName.add(user);
        }
      }

      return findByName.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(findByName);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @Operation(description="Register an User")
  @PostMapping("/user")
  public ResponseEntity<User> registerUser(@RequestBody User user) {
    try {
      userRepository.save(user);

      return ResponseEntity.status(HttpStatus.OK).body(user);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @Operation(description="Update an user data")
  @PutMapping("/user")
  public ResponseEntity<User> editUser(@RequestBody User user) {
    try {
      User user_returned = userRepository.save(user);

      return ResponseEntity.status(HttpStatus.OK).body(user_returned);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @Operation(description="Returns the list of all Users registered")
  @GetMapping("/list")
  public ResponseEntity<List<User>> listUsers() {
    try {
      List<User> list = userRepository.findAll();

      return ResponseEntity.status(HttpStatus.OK).body(list);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
}
