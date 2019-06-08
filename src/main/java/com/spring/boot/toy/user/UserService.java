package com.spring.boot.toy.user;

import com.spring.boot.toy.CustomPasswordEncoder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final CustomPasswordEncoder customPasswordEncoder;

  public void join(User user) {
    boolean existsEmail = userRepository.existsByEmail(user.getEmail());

    if (existsEmail) {
      throw new RuntimeException("중복된 이메일입니다.");
    } else {
      user.changePassword(customPasswordEncoder.encode(user.getPassword()));
      userRepository.save(user);
    }
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(""));
  }

  public String findByEmail(String email) {
    return "";
  }
}
