package com.execinema.restfulapi_cinetown.api.model;

import com.execinema.restfulapi_cinetown.domain.Cinema;
import com.execinema.restfulapi_cinetown.domain.Film;

import java.io.Serializable;


public class ScheduleDTO implements Serializable {

    private static final long serialVersionUID = -7132319818370112070L;
    private Cinema cinema;
    private Film film;

    public ScheduleDTO() {
    }

    public ScheduleDTO(Cinema cinema, Film film) {
        this.cinema = cinema;
        this.film = film;
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
    public String toString() {
        return "ScheduleDTO{" +
                "cinema=" + cinema +
                ", film=" + film +
                '}';
    }
}
