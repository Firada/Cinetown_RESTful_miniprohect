package com.execinema.restfulapi_cinetown.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@IdClass(FilmId.class)
public class Film {

    @Id
    private String name;

    @Id
    private String producer;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<Schedule> schedules = new HashSet<>();

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public Film() {
    }

    public Film(String name, String producer, String description, Set<Schedule> schedules) {
        this.name = name;
        this.producer = producer;
        this.description = description;
        this.schedules = schedules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        return Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
