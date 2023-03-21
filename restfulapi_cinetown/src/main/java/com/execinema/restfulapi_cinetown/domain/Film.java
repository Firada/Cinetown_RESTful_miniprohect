package com.execinema.restfulapi_cinetown.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@IdClass(FilmId.class)
public class Film {

    @Id
    private String name;

    @Id
    private String producer;

/*    @EmbeddedId
    private FilmId filmId;*/

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<Schedule> schedules;

}
