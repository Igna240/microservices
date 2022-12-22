package com.ignacio.catalogservice.domain.model.dto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Data
@Document
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class CatalogWS {
	private String genre;
	private Set<MovieWS> movies;
	private Set<SerieWS> series;

	public CatalogWS() {

	}
}
