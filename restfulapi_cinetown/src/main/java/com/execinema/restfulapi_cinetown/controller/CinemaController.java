package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.api.model.ListCinemaDTO;
import com.execinema.restfulapi_cinetown.api.model.ListFilmDTO;
import com.execinema.restfulapi_cinetown.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    //GET
    @GetMapping("/cinema/{cinemaName}/films")
    @ResponseStatus(HttpStatus.OK)
    public ListFilmDTO getFilmListByCinemaName(@PathVariable String cinemaName){
        return cinemaService.getFilmListByCinemaName(cinemaName);
    }

  /*  @GetMapping("/cinema/all/city/{cityName}/film/{film}/producer/{producer}")
    @ResponseStatus(HttpStatus.OK)
    public ListCinemaDTO getCinemaListByCityNameFilmNameAndProducer(@PathVariable String cityName,
                                                                    @PathVariable String film,
                                                                    @PathVariable String producer){
        return cinemaService.getCinemaListByCityNameFilmNameAndProducer(cityName, film, producer);
    }*/

    @GetMapping("/cinema/all/city/{cityName}/film/{filmName}/producer/{producer}")
    @ResponseStatus(HttpStatus.OK)
    public ListCinemaDTO getCinemaListByCityNameFilmNameProducerAndDistance(@PathVariable String cityName,
                                                                            @PathVariable String filmName,
                                                                            @PathVariable String producer,
                                                                            @RequestParam(required = false) Double distance){
        return cinemaService.getCinemaListByCityNameFilmNameProducerAndDistance(cityName, filmName, producer, distance );
    }


    //DELETE
    @DeleteMapping("/cinema/{cinemaName}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCinemaByName(@PathVariable String cinemaName){
        cinemaService.deleteCinemaByName(cinemaName);
    }




}
