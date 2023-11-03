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

    @GetMapping
    public ResponseEntity<List<Movie>> getMovie() {
       List <Movie> movies = movieService.getMoviesByTitle();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id ) {
        Optional <Movie> movies = movieService.getMovieById(id);
//        if statements from reveiw
        if(movies.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies.get(), HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<Movie> addedMovies( @RequestBody Movie movie){
        movieService.addNewMovie ( movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);

    }



}
