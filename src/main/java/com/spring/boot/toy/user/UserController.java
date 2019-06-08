package com.spring.boot.toy.user;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/user")
public class UserController {

  private final UserService userService;
  private final ModelMapper modelMapper;

  @PostMapping("/join")
  @ResponseStatus(HttpStatus.OK)
  public User join(@RequestBody UserDto dto) {
    User user = dto.toEntity(modelMapper);
    userService.join(user);
    return user;
  }
}
