package com.task.demo.service;

import com.task.demo.model.dto.UserDto;
import com.task.demo.model.entity.User;
import com.task.demo.model.mapper.UserMapper;
import com.task.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {
    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void findTop20ByUserId_worksCorrectly(){

        userMapper.usersDtoToUsers(userService.findTop20ByUserId(1L));

        verify(userRepository).findTop20ByUserIdOrderByResultDescLevelIdDesc(1L);
    }

    @Test
    public void findTop20ByLevelId_worksCorrectly(){

        userMapper.usersDtoToUsers(userService.findTop20ByLevelId(1L));

        verify(userRepository).findTop20ByLevelIdOrderByResultDescUserIdDesc(1L);
    }

    @Test
    public void saveUser_worksCorrectly(){
        UserDto user = new UserDto();
        user.setUserId(1L);
        user.setLevelId(1L);
        user.setResult(1L);

        userService.saveUser(user);

        verify(userRepository, times(1)).save(any());
    }



}
