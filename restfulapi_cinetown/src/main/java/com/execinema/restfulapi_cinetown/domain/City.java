package com.execinema.restfulapi_cinetown.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Set;

@Data
@Entity
public class City {

    @Id
    private String name;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "city")
    private Set<Cinema> cinemas;

    public City(){}

    public City(String name){
        this.name = name;
    }


}
