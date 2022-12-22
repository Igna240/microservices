package com.ignacio.catalogservice.api.service.impl;

import com.ignacio.catalogservice.api.service.CatalogService;
import com.ignacio.catalogservice.domain.model.dto.Catalog;
import com.ignacio.catalogservice.domain.model.dto.dto.CatalogWS;
import com.ignacio.catalogservice.domain.model.dto.dto.MovieWS;
import com.ignacio.catalogservice.domain.model.dto.dto.SerieWS;
import com.ignacio.catalogservice.domain.repository.MovieFeignRepository;
import com.ignacio.catalogservice.domain.repository.CatalogRepository;
import com.ignacio.catalogservice.domain.repository.SerieFeignRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

	private CatalogRepository catalogRepository;
	private MovieFeignRepository movieFeignRepository;
	private SerieFeignRepository serieFeignRepository;

	@Override
	public CatalogWS getUserCatalog(String genre){
		Set<MovieWS> movieWS = movieFeignRepository.getMoviesByGenero(genre);
		Set<SerieWS> serieWS = serieFeignRepository.getSeriesByGenre(genre);
		Catalog catalog = catalogRepository.findByGenre(genre).orElse(null);
		if (catalog != null) {
			catalogRepository.deleteByGenre(genre);
			Catalog catalog1 = new Catalog(genre, movieWS, serieWS);
			catalogRepository.save(catalog1);
		}else{
			Catalog catalog1 = new Catalog(genre, movieWS, serieWS);
			catalogRepository.save(catalog1);
		}
		log.info("Ejecutando..");
		CatalogWS done = CatalogWS.builder()
				.genre(genre)
				.movies(movieWS)
				.series(serieWS)
				.build();

		return done;
	}

	@Override
	public void saveSerie(SerieWS serieWS) {
		Catalog catalog = catalogRepository.findByGenre(serieWS.getGenre()).orElse(null);
		if (catalog != null) {
			catalog.getSeries().add(serieWS);
			catalogRepository.deleteByGenre(serieWS.getGenre());
			catalogRepository.save(catalog);}
		else if(catalog == null) {
			Set<SerieWS> serieWS1 = new HashSet<>();
			serieWS1.add(serieWS);
			Catalog catalog1 = new Catalog(serieWS.getGenre(), null, serieWS1);
			catalogRepository.save(catalog1);
		}
	}

	@Override
	public void saveMovie(MovieWS movieWS) {
		Catalog catalog = catalogRepository.findByGenre(movieWS.getGenre()).get();
		catalog.getMovies().add(movieWS);
		catalogRepository.deleteByGenre(movieWS.getGenre());
		catalogRepository.save(catalog);
	}

	}






