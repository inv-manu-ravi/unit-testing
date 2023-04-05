package com.example.unit.testing.service.Impl;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

@Override
public ResponseEntity<UserView> add(@Valid UserForm userForm) {
    User user = new User(userForm.getFirstName(), userForm.getLastName(), userForm.getEmail(),userForm.getPassword());
    User savedUser = userRepository.save(user);
    UserView userView = new UserView(savedUser);
    logger.info("Email = {} ", userForm.getEmail());
    logger.info("User view: {}", userView);
    return ResponseEntity.status(HttpStatus.CREATED).body(userView);
}
}