package com.ignacio.seriesService.controller;

import com.ignacio.seriesService.config.queue.SeriesSender;
import com.ignacio.seriesService.model.Serie;
import com.ignacio.seriesService.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private ISerieService serieService;
    @Autowired
    private SeriesSender seriesSender;

    //GETBYGENRE
    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre){
        return ResponseEntity.ok().body(serieService.getSeriesByGenre(genre));
    }

    //GETBYID
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Serie>> findbyid(@PathVariable String id){
        return ResponseEntity.ok().body(serieService.findById(id));
    }

    //POST
    @PostMapping("/guardar")
    public String saveSerie(@RequestBody Serie serie){
        serieService.saveSerieService(serie);
        seriesSender.send(serie);
        return "Success!";
    }


}
