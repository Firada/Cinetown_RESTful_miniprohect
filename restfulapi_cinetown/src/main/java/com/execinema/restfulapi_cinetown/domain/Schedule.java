package com.execinema.restfulapi_cinetown.domain;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cinema_name")
    private Cinema cinema;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "film_name"),
                @JoinColumn(name = "film_producer")
                })
    private Film film;

}
