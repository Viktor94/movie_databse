package com.greenfox.movie.services.authority;

import com.greenfox.movie.domains.authorities.Authorities;

public interface AuthoritiesService {

  Authorities findAuthorityByUsername(String username);

}
