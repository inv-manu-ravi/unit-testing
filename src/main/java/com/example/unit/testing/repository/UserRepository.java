package com.example.unit.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unit.testing.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String string);

}
