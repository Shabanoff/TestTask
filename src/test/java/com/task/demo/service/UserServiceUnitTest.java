package com.task.demo.service;

import com.task.demo.model.entity.User;
import com.task.demo.repository.UserRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@Tag("unit")
@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    public void findTop20ByUserId_worksCorrectly(){

        userService.findTop20ByUserId(1L);

        verify(userRepository).findTop20ByUserIdOrderByResultDescLevelIdDesc(1L);
    }

    @Test
    public void findTop20ByLevelId_worksCorrectly(){

        userService.findTop20ByLevelId(1L);

        verify(userRepository).findTop20ByLevelIdOrderByResultDescUserIdDesc(1L);
    }

    @Test
    public void saveUser_worksCorrectly(){
        User user = new User(1L, 1L, 1L);

        userService.create(user);
        verify(userRepository).save(any());
    }



}
