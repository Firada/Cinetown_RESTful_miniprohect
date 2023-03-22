package com.execinema.restfulapi_cinetown.domain;

import javax.persistence.*;
import java.util.Objects;

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

    public Schedule() {
    }

    public Schedule(Long id, Cinema cinema, Film film) {
        this.id = id;
        this.cinema = cinema;
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        return Objects.equals(id, schedule.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", cinema=" + cinema +
                ", film=" + film +
                '}';
    }
}
