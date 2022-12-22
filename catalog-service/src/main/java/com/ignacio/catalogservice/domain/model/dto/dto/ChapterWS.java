package com.ignacio.catalogservice.domain.model.dto.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
public class ChapterWS {
    private String name;
    private Integer number;
    private String urlStream;
}
