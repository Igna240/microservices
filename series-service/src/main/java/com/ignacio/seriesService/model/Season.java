package com.ignacio.seriesService.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Season {
    private int seasonNumber;
    private List<Chapter> chapters;
}
