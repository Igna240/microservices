package com.ignacio.seriesService.service;

import com.ignacio.seriesService.model.Serie;

import java.util.List;
import java.util.Optional;

public interface ISerieService {
    List<Serie> getSeriesByGenre(String genre);
    Optional<Serie> findById(String id);
    void saveSerieService(Serie serie);
}
