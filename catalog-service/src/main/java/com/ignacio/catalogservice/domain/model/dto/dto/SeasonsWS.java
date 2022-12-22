package com.ignacio.catalogservice.domain.model.dto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SeasonsWS {
    private Integer seasonNumber;
    private List<ChapterWS> chapters;
}
