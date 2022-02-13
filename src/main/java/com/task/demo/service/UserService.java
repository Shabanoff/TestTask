package com.task.demo.service;

import com.task.demo.controller.error.UserNotFoundException;
import com.task.demo.model.dto.UserDto;
import com.task.demo.model.mapper.UserMapper;
import com.task.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findTop20ByUserId (Long userId) throws UserNotFoundException {
        return userMapper.usersToUsersDto(
                userRepository.findTop20ByUserIdOrderByResultDescLevelIdDesc(userId));
    }

    public List<UserDto> findTop20ByLevelId (Long levelId){
        return userMapper.usersToUsersDto(
                userRepository.findTop20ByLevelIdOrderByResultDescUserIdDesc(levelId));
    }

    public void saveUser(UserDto userDto) {
           userRepository.save(userMapper.userDtoToUser(userDto));
    }

}

