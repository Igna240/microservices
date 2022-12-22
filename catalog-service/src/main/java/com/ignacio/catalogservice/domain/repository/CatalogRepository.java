package com.ignacio.catalogservice.domain.repository;

import com.ignacio.catalogservice.domain.model.dto.Catalog;
import com.ignacio.catalogservice.domain.model.dto.dto.CatalogWS;
import com.ignacio.catalogservice.domain.model.dto.dto.MovieWS;
import com.ignacio.catalogservice.domain.model.dto.dto.SerieWS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, String> {
    Optional<Catalog> findByGenre (String genre);
    void deleteByGenre(String genre);



}
