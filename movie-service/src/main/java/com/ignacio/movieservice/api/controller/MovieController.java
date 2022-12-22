package com.ignacio.movieservice.api.controller;

import com.ignacio.movieservice.api.service.MovieService;
import com.ignacio.movieservice.api.config.queue.MovieSender;
import com.ignacio.movieservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieSender movieSender;

    //GETBYGENRE
    @RequestMapping({ "/genre/{genre}" })
    public ResponseEntity<Set<Movie>> findAllByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.getListByGenre(genre));
    }

    //GETBYID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> findbyid(@PathVariable Integer id){
        return ResponseEntity.ok().body(movieService.findById(id));
    }

    //SAVEANDSEND
    @PostMapping("/salvar")
    public String saveMovie(@RequestBody Movie movie) {
        movieService.save(movie);
        movieSender.send(movie);
        return "Success!";
    }


    //DELETEBYID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        movieService.delete(id);
    }




}
