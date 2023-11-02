package com.bnta.spring_cinema.services;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {
    MovieRepository movieRepository;
    Movie movie;


    @Autowired

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public String getMoviesByTitle(){
        return movie.getTitle();
    }

    public Optional <Movie> getMovieById(Long id){
        return movieRepository.findById(id);

    }

    public Movie addNewMovie(Movie movie){
        return movieRepository.save(movie);

    }




}
