package com.ignacio.catalogservice.api.controller;

import com.ignacio.catalogservice.api.service.CatalogService;
import com.ignacio.catalogservice.domain.model.dto.dto.CatalogWS;
import com.ignacio.catalogservice.domain.model.dto.dto.MovieWS;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/catalog")
public class CatalogController {
	private CatalogService catalogService;

	@GetMapping("/{genre}")
	public CatalogWS findAllByGenre(@PathVariable String genre) {
		return catalogService.getUserCatalog(genre);
	}










}
