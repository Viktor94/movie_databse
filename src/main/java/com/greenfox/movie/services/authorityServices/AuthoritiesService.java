package com.greenfox.movie.services.authorityServices;

import com.greenfox.movie.domains.authoritiesDomains.Authorities;

public interface AuthoritiesService {

  Authorities findAuthorityByUsername(String username);

}
