package com.greenfox.movie.services.authority;

import com.greenfox.movie.domains.authorities.Authorities;
import com.greenfox.movie.repositories.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

  AuthoritiesRepository authoritiesRepository;

  @Autowired
  public AuthoritiesServiceImpl(
      AuthoritiesRepository authoritiesRepository) {
    this.authoritiesRepository = authoritiesRepository;
  }

  @Override
  public Authorities findAuthorityByUsername(String username) {
    return authoritiesRepository.findByUsername(username);
  }
}
