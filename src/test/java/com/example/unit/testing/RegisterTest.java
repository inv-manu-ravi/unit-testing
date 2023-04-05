package com.example.unit.testing;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        userForm.setFirstName("Ravi");
        userForm.setLastName("Ravi");
        userForm.setEmail("asasas@dgdg.dgdg"); 
        userForm.setPassword("Manu@123");;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserForm>> violations = validator.validate(userForm);
        Assertions.assertEquals(0, violations.size());
    }
    @Test
    void testLastNameIsRequired() {
        UserForm userForm = new UserForm();
        userForm.setFirstName("Ravi");
        userForm.setLastName("hi");
        userForm.setEmail("asasas@dgdg.dgdg"); 
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserForm>> violations = validator.validate(userForm);
        Assertions.assertEquals(0, violations.size());
    }
    public static class ValidationUtils {
        public static boolean isValid(UserForm userForm) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<UserForm>> violations = validator.validate(userForm);
    
            return violations.isEmpty();
        }
        public static boolean isValidPassword(String password) {
            // Check if password is at least 8 characters long
            if (password.length() < 8) {
                return false;
            }
    
            // Check if password contains at least one uppercase letter
            boolean hasUppercase = !password.equals(password.toLowerCase());
            if (!hasUppercase) {
                return false;
            }
    
            // Check if password contains at least one lowercase letter
            boolean hasLowercase = !password.equals(password.toUpperCase());
            if (!hasLowercase) {
                return false;
            }
    
            // Check if password contains at least one digit
            boolean hasDigit = password.matches(".*\\d.*");
            if (!hasDigit) {
                return false;
            }
    
            // Check if password contains at least one special character
            boolean hasSpecialChar = !password.matches("[a-zA-Z0-9 ]*");
            if (!hasSpecialChar) {
                return false;
            }
    
            // All validation checks passed, so the password is valid
            return true;
        }
    }
    
    @Test
    void testValidEmail() {
        UserForm userForm = new UserForm();
        userForm.setFirstName("John");
        userForm.setLastName("Doe");
        userForm.setEmail("johndoe@example.com");
        // Validation should pass for a valid email
        Assertions.assertTrue(ValidationUtils.isValid(userForm));
    }

    @Test
    void testInvalidEmail() {
        UserForm userForm = new UserForm();
        userForm.setFirstName("John");
        userForm.setLastName("Doe");
        userForm.setEmail("johndcc@alecom");
        // Validation should fail for an invalid email
        Assertions.assertFalse(ValidationUtils.isValid(userForm));
    }
     @Test
    void testValidPassword() {
        String password = "Password1@";
        // Validation should pass for a valid password
        Assertions.assertTrue(ValidationUtils.isValidPassword(password));
    }

    @Test
    void testPasswordWithoutUppercaseLetter() {
        String password = "password1@";
        // Validation should fail for a password without an uppercase letter
        Assertions.assertFalse(ValidationUtils.isValidPassword(password));
    }

    @Test
    void testPasswordWithoutLowercaseLetter() {
        String password = "PASSWORD1@";
        // Validation should fail for a password without a lowercase letter
        Assertions.assertFalse(ValidationUtils.isValidPassword(password));
    }

    @Test
    void testPasswordWithoutSpecialCharacter() {
        String password = "Password1";
        // Validation should fail for a password without a special character
        Assertions.assertFalse(ValidationUtils.isValidPassword(password));
    }

    @Test
    void testPasswordWithoutNumber() {
        String password = "Password@";
        // Validation should fail for a password without a number
        Assertions.assertFalse(ValidationUtils.isValidPassword(password));
    }

    @Test
    void testPasswordWithLessThan8Characters() {
        String password = "Pass1@";
        // Validation should fail for a password with less than 8 characters
        Assertions.assertFalse(ValidationUtils.isValidPassword(password));
    }
}