package com.greenfox.movie.controllers;

import com.greenfox.movie.domains.Movie;
import com.greenfox.movie.services.MovieDtoService;
import com.greenfox.movie.services.RetrofitService;
import java.io.IOException;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  MovieDtoService movieDtoService;

  @Autowired
  public RestController(MovieDtoService movieDtoService) {
    this.movieDtoService = movieDtoService;
  }

  @GetMapping("/findbyid/{id}")
  public ResponseEntity<Movie> findById(@PathVariable Long id) {

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build();

    RetrofitService retrofitService = retrofit.create(RetrofitService.class);

    Call<Movie> call = retrofitService.findById(id, "df1d45b5b8bbcfd631418b90fa624680");

    try {
      Response<Movie> response = call.execute();
      Movie movie = response.body();

      movieDtoService.saveMovieDto(movie);

      return ResponseEntity.ok().body(movie);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ResponseEntity.badRequest().body(null);
  }
}
