package com.example.unit.testing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.unit.testing.form.UserForm;
import com.example.unit.testing.service.UserService;
import com.example.unit.testing.view.UserView;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserView> registerUser(@Valid @RequestBody UserForm userForm) {
           return userService.add(userForm);
        
    }
}
