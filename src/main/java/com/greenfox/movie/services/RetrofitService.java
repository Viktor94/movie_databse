package com.greenfox.movie.services;

import com.greenfox.movie.domains.movieFindById.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

  @GET("3/movie/{movie_id}")
  Call<Movie> findById(
      @Path("movie_id") Long id,
      @Query("api_key") String key);


}
