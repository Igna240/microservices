package com.ignacio.seriesService.service.impl;

import com.ignacio.seriesService.model.Serie;
import com.ignacio.seriesService.repository.SerieRepository;
import com.ignacio.seriesService.service.ISerieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SerieServiceImpl implements ISerieService {

    @Autowired
    private SerieRepository serieRepository;
    @Override
    public List<Serie> getSeriesByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    @Override
    public Optional<Serie> findById(String id) {
        return serieRepository.findById(id);
    }

    @Override
    public void saveSerieService(Serie serie){
        log.info("Intentado guardar la serie");
        serieRepository.save(serie);
    }


}