package com.example.unit.testing.form;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserForm {
@NotBlank(message = "First name is required")
private String firstName;

@NotBlank(message = "Last name is required")
private String lastName;

@NotBlank(message = "Email is required")
@Pattern(regexp = "^[\\w-\\.]+@(?!.*\\.\\d)(?!.*\\.\\-)[A-Za-z0-9-]+(\\.[A-Za-z]{2,})(\\.([A-Za-z]{2,}))?$", message = "Invalid email address")
private String email;
@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&`~])[A-Za-z\\d@$!%*?&`~]{8,}$")
private String password;
}
