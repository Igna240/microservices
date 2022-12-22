package com.ignacio.catalogservice.api.service;

import com.ignacio.catalogservice.domain.model.dto.Catalog;
import com.ignacio.catalogservice.domain.model.dto.dto.CatalogWS;
import com.ignacio.catalogservice.domain.model.dto.dto.MovieWS;
import com.ignacio.catalogservice.domain.model.dto.dto.SerieWS;

import java.io.Serializable;

public interface CatalogService {
    CatalogWS getUserCatalog(String genre);
    void saveMovie(MovieWS movieWS);
    void saveSerie(SerieWS serieWS);


}

