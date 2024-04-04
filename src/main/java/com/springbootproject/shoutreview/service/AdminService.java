package com.springbootproject.shoutreview.service;

import org.springframework.stereotype.Service;

import com.springbootproject.shoutreview.domain.Movie;
import com.springbootproject.shoutreview.repository.MovieRepository;

@Service
public class AdminService {
    
     private MovieRepository movieRepository;

    //constructor injection
    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
