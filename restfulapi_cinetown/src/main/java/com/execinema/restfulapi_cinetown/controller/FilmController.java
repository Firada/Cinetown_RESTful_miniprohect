package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.domain.Film;
import com.execinema.restfulapi_cinetown.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    //POST
    @PostMapping("/film")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewFilm(@RequestBody Film film){
        filmService.createNewFilm(film);
    }

    //DELETE
    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    void deleteFilmByNameAndProducer(@PathVariable String filmName, @PathVariable String producer){
        filmService.deleteFilmByNameAndProducer(filmName, producer);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    void deleteFilmByName(@PathVariable String filmName){
        filmService.deleteFilmByName(filmName);
    }
}
