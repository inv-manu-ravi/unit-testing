package com.example.unit.testing.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import com.example.unit.testing.form.UserForm;
import com.example.unit.testing.view.UserView;

public interface UserService {
    

    ResponseEntity<UserView> add(@Valid UserForm userForm);

}
