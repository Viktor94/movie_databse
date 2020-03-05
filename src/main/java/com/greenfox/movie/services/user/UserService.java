package com.greenfox.movie.services.user;

import com.greenfox.movie.domains.User;

public interface UserService {

  User findUserbyUsername (String name);

}
