package com.ignacio.movieservice.domain.repository;

import com.ignacio.movieservice.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Set<Movie> findAllByGenre(String genre);
}
