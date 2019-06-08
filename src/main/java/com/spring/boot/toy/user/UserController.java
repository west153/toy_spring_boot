package com.spring.boot.toy.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/rest/user")
public class UserController {

  private UserRepository userRepository;

  @PostMapping("/reg")
  public void register(@RequestBody UserDto dto) {
    userRepository.save(dto.toEntity());
  }
}
