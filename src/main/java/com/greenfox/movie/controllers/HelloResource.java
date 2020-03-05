package com.greenfox.movie.controllers;

import com.greenfox.movie.Utilities.JwtUtil;
import com.greenfox.movie.domains.AuthenticationRequest;
import com.greenfox.movie.domains.AuthenticationResponse;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

  private AuthenticationManager authenticationManager;
  private UserDetailsService userDetailsService;
  private JwtUtil jwtUtil;

  @Autowired
  public HelloResource(
      AuthenticationManager authenticationManager,
      UserDetailsService userDetailsService, JwtUtil jwtUtil) {
    this.authenticationManager = authenticationManager;
    this.userDetailsService = userDetailsService;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/authenticate")
  public ResponseEntity<?> createAuthenticationToken(
      @RequestParam String name, @RequestParam String password) throws Exception {
    AuthenticationRequest authenticationRequest = new AuthenticationRequest(name, password);
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
              authenticationRequest.getPassword()));
    } catch (BadCredentialsException e) {
      throw new ExecutionException("Incorrect username or password", e);
    }
    final UserDetails userDetails = userDetailsService
        .loadUserByUsername(authenticationRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);

    HttpHeaders headers = new HttpHeaders();
    headers.set("SET-COOKIE", "Bearer " + jwt);
    headers.setLocation(URI.create("findbyid/3"));

    return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    //return ResponseEntity.ok().headers(headers).body(new AuthenticationResponse(jwt));
  }
}