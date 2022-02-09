package com.task.demo.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("level_id")
    private Long levelId;

    @JsonProperty("result")
    private Long result;
}
