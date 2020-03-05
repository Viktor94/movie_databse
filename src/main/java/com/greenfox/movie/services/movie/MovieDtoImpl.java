package com.greenfox.movie.services.movie;

import com.greenfox.movie.domains.findMovieById.Movie;
import com.greenfox.movie.domains.findMovieById.MovieDTO;
import com.greenfox.movie.repositories.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  @Override
  public List<MovieDTO> findAllMovie() {
    return (List<MovieDTO>) movieRepository.findAll();
  }
}
