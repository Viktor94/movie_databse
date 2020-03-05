package com.greenfox.movie.repositories;

import com.greenfox.movie.domains.Authorities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {

  Authorities findByUsername(String username);

}
