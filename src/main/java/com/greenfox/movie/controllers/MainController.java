package com.greenfox.movie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  public static String BASE_URL = "https://api.themoviedb.org/";
  public static String API_KEY = "aa80617c1078bff28c66a9bbfe2da7d0";
  public static String LANGUAGE = "en-us";
  public static int page = 1;
  public static String category = "popular";

  @GetMapping("/")
  public String login () {
    return "login";
  }



  /*
  @GetMapping("/find-by-id")
  public String findById(Model model) {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build();

    RetrofitService retrofitService = retrofit.create(RetrofitService.class);
    Call<Movie> call = retrofitService.findById(3L, "df1d45b5b8bbcfd631418b90fa624680", "tvdb_id");
    HttpUrl url = call.request().url();
    try {
      Response<Movie> response = call.execute();
      System.out.println(response.toString());
      Movie movie = response.body();
      model.addAttribute("movie", movie);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return "asd";
  }

   */

}
