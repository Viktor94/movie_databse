package com.greenfox.movie.services.movieServices;

import com.greenfox.movie.domains.movieFindById.Movie;
import com.greenfox.movie.domains.movieFindById.MovieDTO;

public interface MovieDtoService {

  void saveMovieDto (Movie movie);

  Iterable<MovieDTO> findAllMovie ();

}
