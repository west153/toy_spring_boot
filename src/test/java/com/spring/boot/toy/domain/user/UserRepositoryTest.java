package com.spring.boot.toy.domain.user;

import com.spring.boot.toy.user.User;
import com.spring.boot.toy.user.UserRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @After
  public void clear() {
    userRepository.deleteAll();
  }

  @Test
  public void register() {
    LocalDateTime now = LocalDateTime.now();
    userRepository.save(User.builder()
        .name("김다슬")
        .email("test@test.test")
        .password("password")
        .build());

    List<User> userList = userRepository.findAll();

    User user = userList.get(0);
    assertThat(user.getName(), is("김다슬"));
    assertThat(user.getEmail(), is("test@test.test"));
    assertTrue(user.getCreatedTime().isAfter(now));
    assertTrue(user.getModifiedTime().isAfter(now));
  }

}
