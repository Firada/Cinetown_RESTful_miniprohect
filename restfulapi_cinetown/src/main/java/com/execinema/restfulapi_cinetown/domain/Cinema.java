package com.execinema.restfulapi_cinetown.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Cinema {

    @Id
    private String name;

    private String address;
    private Double distanceFromCityCenter;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cityName", nullable = false)
    private City city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinema")
    private Set<Schedule> schedules;


}
