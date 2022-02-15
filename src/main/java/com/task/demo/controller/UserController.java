package com.task.demo.controller;

import com.task.demo.model.dto.UserDto;
import com.task.demo.model.entity.User;
import com.task.demo.model.mapper.UserMapper;
import com.task.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/userinfo/{user_id}")
    List<UserDto> userInfo(@PathVariable Long user_id) {
        return userMapper.usersToUsersDto(userService.findTop20ByUserId(user_id));
    }

    @GetMapping("/levelinfo/{level_id}")
    List<UserDto> levelInfo(@PathVariable Long level_id){
        return userMapper.usersToUsersDto(userService.findTop20ByLevelId(level_id));
    }

    @PostMapping("/setinfo/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto setInfo(@Validated(UserDto.class) @RequestBody UserDto userDto){
        User user = userService.create(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

}

