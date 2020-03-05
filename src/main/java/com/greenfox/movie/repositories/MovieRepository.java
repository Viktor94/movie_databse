package com.greenfox.movie.repositories;

import com.greenfox.movie.domains.findMovieById.MovieDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieDTO, Long> {

}
