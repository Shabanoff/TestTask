package com.task.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.demo.controller.UserController;
import com.task.demo.model.entity.User;
import com.task.demo.repository.UserRepository;
import com.task.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserRepository userRepository;
    @MockBean
    UserService userService;

    User user1 = new User(1l, 1l,1l,2l);
    User user2 = new User(2l, 1l,2l,1l);
    User user3 = new User(3l, 2l,2l,3l);

    @Test
    public void getTopResultOfUser()throws Exception{

        Mockito.when(userRepository.findTop20ByUserIdOrderByResultDescLevelIdDesc(user1.getUserId())).thenReturn(List.of(user1));

        mockMvc.perform(MockMvcRequestBuilders.get("/userinfo/1").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(2))).
                andExpect((ResultMatcher) jsonPath("$[0].user_id", is("1"))).
                andExpect(jsonPath("$[0].did", anything())).
                andExpect((ResultMatcher) jsonPath("$[1].user_id", is("1")));
    }
}
