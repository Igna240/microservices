package com.ignacio.catalogservice.domain.model.dto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieWS {

    private Integer id;
    private String name;
    private String genre;
    private String urlStream;
}
