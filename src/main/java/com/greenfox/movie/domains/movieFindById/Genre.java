package com.greenfox.movie.domains.movieFindById;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genre {

  @SerializedName("id")
  @Expose
  public Integer id;

  @SerializedName("name")
  @Expose
  public String name;
}