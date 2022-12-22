package com.ignacio.seriesService.repository;

import com.ignacio.seriesService.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends MongoRepository<Serie, String> {
    List<Serie> findAllByGenre(String genre);

}
