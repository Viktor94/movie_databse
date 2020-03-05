package com.greenfox.movie.domains.movieFindById;

import com.greenfox.movie.domains.movieFindById.Movie;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

  @Id
  private Integer id;
  private Integer revenue;
  private String title;

  public MovieDTO(Movie movie) {
    this.id = movie.id;
    this.revenue = movie.revenue;
    this.title = movie.title;
  }
}
