package com.example.unit.testing.service.Impl;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.unit.testing.view.UserView;
import com.example.unit.testing.entity.User;
import com.example.unit.testing.form.UserForm;
import com.example.unit.testing.repository.UserRepository;
import com.example.unit.testing.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // @Override
    // public User save(UserForm userForm) {
    //     return new UserView(userRepository.save(new User(
    //         form.getName(),
    //         form.getEmail(),
    //         passwordEncoder.encode(form.getPassword())
    // )));
    // }

  

@Override
public ResponseEntity<UserView> add(@Valid UserForm userForm) {
    User user = new User(userForm.getFirstName(), userForm.getLastName(), userForm.getEmail());
    User savedUser = userRepository.save(user);
    UserView userView = new UserView(savedUser);
    System.out.println(userView);
    return ResponseEntity.status(HttpStatus.CREATED).body(userView);
}
}