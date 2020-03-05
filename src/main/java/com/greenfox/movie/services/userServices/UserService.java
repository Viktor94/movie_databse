package com.greenfox.movie.services.userServices;

import com.greenfox.movie.domains.User;

public interface UserService {

  User findUserbyUsername (String name);

}
