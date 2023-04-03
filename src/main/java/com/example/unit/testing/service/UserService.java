package com.example.unit.testing.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.example.unit.testing.entity.User;
import com.example.unit.testing.form.UserForm;

public interface UserService {
    

    ResponseEntity<?> add(@Valid UserForm userForm);
}
