package com.execinema.restfulapi_cinetown.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class City {

    @Id
    private String name;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "city")
    private Set<Cinema> cinemas = new HashSet<>();

    public City(){}

    public City(String name){
        this.name = name;
    }

    public City(String name, Set<Cinema> cinemas) {
        this.name = name;
        this.cinemas = cinemas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(Set<Cinema> cinemas) {
        this.cinemas = cinemas = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", cinemas=" + cinemas +
                '}';
    }
}
