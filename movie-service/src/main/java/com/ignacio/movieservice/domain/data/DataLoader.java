package com.ignacio.movieservice.domain.data;

import com.ignacio.movieservice.domain.model.Movie;
import com.ignacio.movieservice.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final MovieRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Movie(1, "A Trip to Infinity", "Documentary", "https://www.netflix.com/title/81273453"));
        repository.save(new Movie(2, "The Figo Affair", "Documentary", "https://www.netflix.com/title/81386989"));
        repository.save(new Movie(3, "Zombieland: Doble Tap", "Horror", "https://www.netflix.com/title/81093420"));
        repository.save(new Movie(4, "World War Z", "Horror", "https://www.netflix.com/title/70262639"));
        repository.save(new Movie(5, "Full Mental Alchemist", "Action", "https://www.netflix.com/title/81266981"));
        repository.save(new Movie(6, "Fury", "Action", "https://www.netflix.com/title/70305907"));
        repository.save(new Movie(7, "Triple 9", "Police", "https://www.netflix.com/title/80045504"));
        repository.save(new Movie(8, "The Perfumier", "Police", "https://www.netflix.com/title/81410551"));
    }
}
