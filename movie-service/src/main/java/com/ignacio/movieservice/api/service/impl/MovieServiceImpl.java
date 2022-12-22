package com.ignacio.movieservice.api.service.impl;

import com.ignacio.movieservice.api.service.MovieService;
import com.ignacio.movieservice.domain.model.Movie;
import com.ignacio.movieservice.domain.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public Set<Movie> getListByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }
    //POST
    @Override
    public Movie save(Movie movie) {
        log.info("Intentado guardar la pelicula");
        return movieRepository.save(movie);
    }

    //GETBYID
    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    //DELETE
    @Override
    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }


}