package com.thientvse.springwebapp.service;

import com.thientvse.springwebapp.model.User;
import com.thientvse.springwebapp.repository.UserRepository;
import com.thientvse.springwebapp.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    private UserService userService;


    @Before
    public void init(){
        this.userService = new UserService(userRepository);
    }

    @Test
    public void getAllCommentsForToday_HappyPath_ShouldReturnComment(){
        // Given
        User user = new User();
        user.setUsername("Thientv");
        user.setPassword("123456a@");
        user.setRole("USER");

        when(userRepository.findByUsername("Thientv")).thenReturn(user);

        // When
        UserDetails actual = userService.loadUserByUsername("Thientv");

        // Then
        verify(userRepository,times(1)).findByUsername("Thientv");
    }
}
