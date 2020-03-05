package com.greenfox.movie.services;

import com.greenfox.movie.domains.Movie;
import com.greenfox.movie.domains.MovieDTO;
import com.greenfox.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;

@Service
public class MovieDtoImpl implements MovieDtoService {

  MovieRepository movieRepository;

  @Autowired
  public MovieDtoImpl(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Override
  public void saveMovieDto(Movie movie) {
    movieRepository.save(new MovieDTO(movie));
  }


}
