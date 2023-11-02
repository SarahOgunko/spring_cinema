package com.bnta.spring_cinema.controllers;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(value = "/movies")
    public ResponseEntity<Movie> getMovie(@RequestParam String title ) {
        Movie movie = movieService.getMoviesByTitle();

    }

    @GetMapping(value = "/movies")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id ) {
        Optional movie = movieService.getMovieById(id);

    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Movie> addMovies (@PathVariable long id, @RequestBody Movie  movie){
        Movie newMovie = movieService.addNewMovie ( movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);

    }




}
