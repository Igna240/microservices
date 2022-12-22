package com.ignacio.seriesService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
@NoArgsConstructor
public class Serie {

    private String id;
    private String name;
    private String genre;
    private List<Season> seasons;

}
