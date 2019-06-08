package com.spring.boot.toy.domain.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.toy.user.UserDto;
import com.spring.boot.toy.user.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @MockBean
  private UserService userService;

  @Test
  public void joinUser() throws Exception {
    UserDto userDto = UserDto.builder()
      .name("kim")
      .email("test@test.test")
      .password("1234")
      .build();

    mockMvc.perform(post("/api/user/join")
      .content(objectMapper.writeValueAsString(userDto))
      .contentType(MediaType.APPLICATION_JSON_UTF8))
      .andDo(print())
      .andExpect(status().isOk());
  }

  @Test
  public void 이메일중복시오류발생() throws Exception {
    UserDto userDto = UserDto.builder()
      .name("kim")
      .email("test@test.test")
      .password("1234")
      .build();

    
    mockMvc.perform(post("/api/user/join")
      .content(objectMapper.writeValueAsString(userDto))
      .contentType(MediaType.APPLICATION_JSON_UTF8))
      .andDo(print())
      .andExpect(status().isConflict());
  }
}
