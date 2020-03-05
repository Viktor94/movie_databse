package com.greenfox.movie.services;

import com.greenfox.movie.domains.Authorities;

public interface AuthoritiesService {

  Authorities findAuthorityByUsername(String username);

}
