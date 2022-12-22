package com.ignacio.catalogservice.domain.repository;

import com.ignacio.catalogservice.domain.model.dto.dto.MovieWS;
import com.ignacio.catalogservice.domain.model.dto.dto.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@FeignClient(name="series-service")
public interface SerieFeignRepository {
    @GetMapping("/series/{genre}")
    Set<SerieWS> getSeriesByGenre(@RequestParam String genre);
}
