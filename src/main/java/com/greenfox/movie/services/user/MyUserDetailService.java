package com.greenfox.movie.services.user;

import com.greenfox.movie.domains.User;
import com.greenfox.movie.services.authority.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyUserDetailService implements UserDetailsService {

  UserService userService;
  AuthoritiesService authoritiesService;

  @Autowired
  public MyUserDetailService(UserService userService,
      AuthoritiesService authoritiesService) {
    this.userService = userService;
    this.authoritiesService = authoritiesService;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userService.findUserbyUsername(username);

    UserBuilder builder = null;

    if (user != null) {
      builder = org.springframework.security.core.userdetails.User.withUsername(username);
      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
      builder.roles(authoritiesService.findAuthorityByUsername(username).getAuthority());
    } else {
      throw new UsernameNotFoundException("User not found");
    }
    return builder.build();
  }
}
