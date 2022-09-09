package com.management.api.database;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.management.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
  public Optional<User> findByCpf(String cpf);
  public Optional<User> findByRg(String rg);
  public Page<User> findAll(Pageable pageable);
}
