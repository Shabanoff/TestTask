package com.task.demo.model;

import com.task.demo.model.dto.UserDto;
import com.task.demo.model.entity.User;
import com.task.demo.model.mapper.UserMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("unit")
@SpringBootTest
public class UserModelMapperUnitTest {

    @Autowired
    private UserMapper mapper;

    @Test
    void mapUserToUserDto_shouldWorkCorrect() {
        User user = new User();
        user.setUserId(1L);
        user.setLevelId(1L);
        user.setResult(1L);

        UserDto actual = mapper.userToUserDto(user);

        assertThat(actual.getUserId()).isEqualTo(user.getUserId());
        assertThat(actual.getLevelId()).isEqualTo(user.getLevelId());
        assertThat(actual.getResult()).isEqualTo(user.getResult());
    }

    @Test
    void mapUserToUserDto_withNullValue_shouldWorkCorrect() {
        User user = new User();

        UserDto actual = mapper.userToUserDto(user);

        assertThat(actual.getUserId()).isNull();
        assertThat(actual.getLevelId()).isNull();
        assertThat(actual.getResult()).isNull();
    }

    @Test
    void mapUserDtoToUser_shouldWorkCorrect() {
        UserDto userDto = new UserDto(1L,1L,1L);


        User actual = mapper.userDtoToUser(userDto);

        assertThat(actual.getUserId()).isEqualTo(userDto.getUserId());
        assertThat(actual.getLevelId()).isEqualTo(userDto.getLevelId());
        assertThat(actual.getResult()).isEqualTo(userDto.getResult());
    }
}
