package com.greenfox.movie.services.movie;

import com.greenfox.movie.domains.findMovieById.Movie;
import com.greenfox.movie.domains.findMovieById.MovieDTO;

public interface MovieDtoService {

  void saveMovieDto (Movie movie);

  Iterable<MovieDTO> findAllMovie ();

}
