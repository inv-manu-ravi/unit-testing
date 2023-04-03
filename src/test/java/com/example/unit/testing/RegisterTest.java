package com.example.unit.testing;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.unit.testing.repository.UserRepository;
import com.example.unit.testing.service.Impl.UserServiceImpl;

public class RegisterTest {
    @InjectMocks
    UserServiceImpl userServiceImpl;
    @Mock
    UserRepository userRepository;
    @BeforeEach
    void setUp()throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }
}
