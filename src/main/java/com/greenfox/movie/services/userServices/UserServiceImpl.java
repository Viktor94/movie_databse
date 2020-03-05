package com.greenfox.movie.services.userServices;

import com.greenfox.movie.domains.User;
import com.greenfox.movie.repositories.UserRepository;
import com.greenfox.movie.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findUserbyUsername(String name) {

    return userRepository.findById(name).orElse(null);
  }
}
