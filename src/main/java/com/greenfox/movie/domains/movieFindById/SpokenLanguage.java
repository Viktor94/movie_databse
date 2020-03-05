package com.greenfox.movie.domains.movieFindById;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {

  @SerializedName("iso_639_1")
  @Expose
  public String iso6391;
  @SerializedName("name")
  @Expose
  public String name;

}