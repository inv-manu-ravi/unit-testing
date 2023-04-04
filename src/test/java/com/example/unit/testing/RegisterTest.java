package com.example.unit.testing;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.unit.testing.form.UserForm;
import com.example.unit.testing.repository.UserRepository;
import org.junit.jupiter.api.Assertions;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RegisterTest {
    
    @Autowired
    private UserRepository userRepository;
    
    private Validator validator;
    
    @BeforeEach
    void setUp() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
//     @Test
//     public void testSave() {
//         UserForm userForm=new UserForm();
//         userForm.setEmail("manuravi565@gmail.com");
//         userForm.setFirstName("manu");
//         userForm.setLastName("Ravi"); 
        
//         // validate the user form object
//         Set<ConstraintViolation<UserForm>> violations = validator.validate(userForm);
//         assertTrue(violations.size() > 0, "Email is invalid Format");
        
        
//         // save the user to the database
//         User user = new User(userForm.getFirstName(), userForm.getLastName(), userForm.getEmail());
//         User savedUser = userRepository.save(user);
        
//         // check if user is saved successfully
//         User retrievedUser = userRepository.findByEmail("manuravi565@gmailscom");
        
//     }
    
// }
@Test
    void testFirstNameIsRequired() {
        UserForm userForm = new UserForm();
        userForm.setLastName("Ravi");
        userForm.setEmail("asasas@dgdg.dgdg"); 
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserForm>> violations = validator.validate(userForm);
        Assertions.assertEquals(0, violations.size());
    }
}