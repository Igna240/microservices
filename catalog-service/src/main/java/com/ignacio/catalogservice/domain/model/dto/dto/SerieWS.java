package com.ignacio.catalogservice.domain.model.dto.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SerieWS {
   // @Id
    private String id;
    private String name;
    private String genre;
    private List<SeasonsWS> seasons;
}
