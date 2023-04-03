package com.example.unit.testing.view;

import com.example.unit.testing.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class UserView {
    private Long id;
    private String firstName;
    private String lastName;
    
    public UserView(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
