package com.task.demo.controller;

import com.task.demo.controller.error.UserNotFoundException;
import com.task.demo.model.dto.UserDto;
import com.task.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/userinfo/{user_id}")
    List<UserDto> userInfo(@PathVariable Long user_id) throws UserNotFoundException {
        return userService.findTop20ByUserId(user_id);
    }

    @GetMapping("/levelinfo/{level_id}")
    List<UserDto> levelInfo(@PathVariable Long level_id){
        return userService.findTop20ByLevelId(level_id);
    }

    @SneakyThrows
    @PostMapping("/setinfo")
    public void setInfo(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

}

