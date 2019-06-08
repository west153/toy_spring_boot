package com.spring.boot.toy.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
  private String name;
  private String email;
  private String password;

  public User toEntity() {
    return User.builder()
        .name(name)
        .email(email)
        .password(password)
        .build();
  }
}
