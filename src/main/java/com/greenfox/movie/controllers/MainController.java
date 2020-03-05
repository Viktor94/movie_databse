package com.greenfox.movie.controllers;

import com.greenfox.movie.services.movieServices.MovieDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  MovieDtoService movieDtoService;

  @Autowired
  public MainController(MovieDtoService movieDtoService) {
    this.movieDtoService = movieDtoService;
  }

  @GetMapping("/")
  public String login() {
    return "login";
  }

  @GetMapping("/index")
  public String main(Model model) {
    model.addAttribute("movies", movieDtoService.findAllMovie());
    return "index";
  }
}
