package com.management.api.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
