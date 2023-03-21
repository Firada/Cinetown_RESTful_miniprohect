package com.execinema.restfulapi_cinetown.service;

import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.domain.FilmId;

import java.util.List;

public interface FilmService {

    //POST
    FilmDTO createNewFilm(Film film);

    //Delete
    void deleteFilmByNameAndProducer(String filmName, String producer);
    void deleteFilmByName(String filmName);
}
