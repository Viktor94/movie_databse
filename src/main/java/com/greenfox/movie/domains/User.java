package com.greenfox.movie.domains;

import com.greenfox.movie.domains.authoritiesDomains.Authorities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

  @Id
  @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
  private String username;

  @NonNull
  private String password;

  @ManyToOne
  Authorities authorities;
}


