package com.task.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.demo.model.dto.UserDto;

public abstract class AbstractControllerTest {

    public static String asJsonString(UserDto userDto) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(userDto);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
