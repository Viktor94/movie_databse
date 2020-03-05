package com.greenfox.movie.services;

import com.greenfox.movie.domains.User;

public interface UserService {

  User findUserbyUsername (String name);

}
