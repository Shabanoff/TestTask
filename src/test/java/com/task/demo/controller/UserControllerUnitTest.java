
package com.task.demo.controller;

import com.task.demo.model.dto.UserDto;
import com.task.demo.service.UserService;
import org.h2.util.json.JSONStringSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static com.task.demo.controller.AbstractControllerTest.asJsonString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(controllers = UserController.class)
class UserControllerUnitTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;


    @Test
    void userInfo_whenValidInput_thenReturns200() throws Exception {
        UserDto user1 = new UserDto(1L, 1L, 1L);
        UserDto user2 = new UserDto(1L, 1L, 1L);

        when(userService.findTop20ByUserId(user1.getUserId())).thenReturn(List.of(user1, user2));

        mockMvc.perform(MockMvcRequestBuilders.get("/userinfo/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void levelInfo_whenValidInput_thenReturns200() throws Exception {
        UserDto user1 = new UserDto(1L, 1L, 1L);
        UserDto user2 = new UserDto(1L, 1L, 1L);

        when(userService.findTop20ByUserId(user1.getUserId())).thenReturn(List.of(user1, user2));

        mockMvc.perform(MockMvcRequestBuilders.get("/levelinfo/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


//    @Test
//    void getTopResultOfLevel_UserNotFound_ShouldReturnHttpStatusCode404() throws Exception{
//        when(userService.findTop20ByUserId(1L)).thenThrow(new UserNotFoundException());
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/levelinfo/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound());
//    }

    @Test
    public void setInfo_whenValidInput_thenReturns200() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/setinfo")
                .content(asJsonString(new UserDto(1L,1L,1L)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").exists());
    }

}
