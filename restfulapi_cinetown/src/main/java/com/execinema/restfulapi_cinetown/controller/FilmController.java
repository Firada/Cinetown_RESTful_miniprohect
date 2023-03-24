package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.api.model.FilmDTO;
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
    public FilmDTO createNewFilm(@RequestBody FilmDTO filmDTO){
        return filmService.createNewFilm(filmDTO);
    }

    //DELETE
    @DeleteMapping("/film/{filmName}/producer/{producer}")
    @ResponseStatus(HttpStatus.OK)
    void deleteFilmByNameAndProducer(@PathVariable String filmName, @PathVariable String producer){
        filmService.deleteFilmByNameAndProducer(filmName, producer);
    }

    @DeleteMapping("/film/{filmName}")
    @ResponseStatus(HttpStatus.OK)
    void deleteFilmByName(@PathVariable String filmName){
        filmService.deleteFilmByName(filmName);
    }
}
