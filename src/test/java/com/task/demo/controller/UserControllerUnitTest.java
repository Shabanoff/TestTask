
package com.task.demo.controller;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.task.demo.model.dto.UserDto;
import com.task.demo.model.entity.User;
import com.task.demo.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = UserController.class)
class UserControllerUnitTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;

    User user2 = new User(2l, 1l, 2l, 1l);
    User user3 = new User(3l, 2l, 2l, 3l);

    @Test
    void getTopResultOfUser() throws Exception {
        UserDto user1 = new UserDto();
        user1.setUserId(1L);
        user1.setLevelId(1L);
        user1.setResult(1L);
        UserDto user2 = new UserDto();
        user2.setUserId(1L);
        user2.setLevelId(1L);
        user2.setResult(1L);
        when(userService.findTop20ByUserId(user1.getUserId())).thenReturn(List.of(user1, user2));

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/userinfo/1").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(2))).
                andExpect((ResultMatcher) jsonPath("$[0].user_id", is("1"))).
                andExpect(jsonPath("$[0].did", anything())).
                andExpect((ResultMatcher) jsonPath("$[1].user_id", is("1")));
    }
}
