package com.spring.boot.toy.user;

import org.modelmapper.ModelMapper;

import lombok.Builder;
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

  @Builder
  private UserDto(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public User toEntity(ModelMapper modelMapper) {
    return modelMapper.map(this, User.class);
  }
}
