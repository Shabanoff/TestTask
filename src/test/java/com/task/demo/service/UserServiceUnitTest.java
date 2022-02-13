package com.task.demo.service;

import com.task.demo.model.dto.UserDto;
import com.task.demo.model.entity.User;
import com.task.demo.model.mapper.UserMapper;
import com.task.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
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
        UserDto userDto = new UserDto(1L, 1L, 1L);

        userService.saveUser(userDto);

         //ArgumentCaptor<UserDto> saveCapture = ArgumentCaptor.forClass(UserDto.class);
         verify(userRepository).save(any());
         //UserDto actual = saveCapture.getValue();
         //assertThat(actual.getUserId()).isEqualTo(1L);
    }



}
