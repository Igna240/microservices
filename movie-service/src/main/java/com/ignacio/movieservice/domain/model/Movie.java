package com.ignacio.movieservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Serializable  { //it will be transmitted over a messaging system.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String genre;
    private String urlStream;
}
