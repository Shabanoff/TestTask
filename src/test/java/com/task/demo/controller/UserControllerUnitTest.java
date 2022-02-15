
package com.task.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.demo.model.dto.UserDto;
import com.task.demo.model.entity.User;
import com.task.demo.model.mapper.UserMapper;
import com.task.demo.model.mapper.UserMapperImpl;
import com.task.demo.service.UserService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("unit")
@WebMvcTest(controllers = UserController.class)
@Import({UserMapperImpl.class})
class UserControllerUnitTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserMapper userMapper;


    @Test
    void userInfo_thenWorkCorrect() throws Exception {
        User user1 = new User(1L, 1L, 1L);
        User user2 = new User(1L, 1L, 1L);

        when(userService.findTop20ByUserId(user1.getUserId())).thenReturn(List.of(user1, user2));

        mockMvc.perform(MockMvcRequestBuilders.get("/userinfo/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void levelInfo_thenWorkCorrect() throws Exception {
        User user1 = new User(1L, 1L, 1L);
        User user2 = new User(1L, 1L, 1L);

        when(userService.findTop20ByLevelId(user1.getUserId())).thenReturn(List.of(user1, user2));

        mockMvc.perform(MockMvcRequestBuilders.get("/levelinfo/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void setInfo_whenValidInput_thenWorkCorrect() throws Exception {
        User user = new User(1L, 1L, 1L);
        UserDto userDto = new UserDto(1L,1L,1L);

        User requestUser = userMapper.userDtoToUser(userDto);
        when(userService.create(requestUser)).thenReturn(user);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/setinfo/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(userDto))
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(userService).create(requestUser);
    }

}
