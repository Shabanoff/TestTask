package com.task.demo.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("level_id")
    private Long levelId;

    @JsonProperty("result")
    private Long result;

}
